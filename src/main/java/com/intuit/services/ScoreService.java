package com.intuit.services;

import com.intuit.exceptions.scoreExceptions.InvalidUsernameException;
import com.intuit.models.Score;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ScoreService {
    public void addScore(Score score) throws Exception;

    public List<Score> top5();

    public List<Score> findAll();

}
