package com.intuit.services;

import com.intuit.cache.ScoreCache;
import com.intuit.exceptions.scoreExceptions.InvalidUsernameException;
import com.intuit.models.Score;
import com.intuit.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private ScoreCache scoreCache;

    @Override
    public void addScore(Score score) throws Exception {
        validateScore(score);
        scoreRepository.save(score);
        scoreCache.getSet().add(score);
    }

    @Override
    public List<Score> top5() {
        try{
            List<Score> scores= retrieveFromCache();
            return scores;
        }
        catch(Exception e){
        }
        return scoreRepository.findTop5ByOrderByScoreDesc();
    }

    private List<Score> retrieveFromCache() throws Exception{
        List<Score> scores= new ArrayList<>();
        for(Score s: scoreCache.getSet()){
            scores.add(s);
            if(scores.size()>=5) break;
        }
        return scores;
    }

    public List<Score> findAll() {
        return scoreRepository.findAll();
    }

    private void validateScore(Score score) throws Exception {
        if(score.getUsername()==null|| score.getUsername().length()==0){
            throw new InvalidUsernameException();
        }
    }
}
