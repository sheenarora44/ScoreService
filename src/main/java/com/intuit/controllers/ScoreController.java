package com.intuit.controllers;

import com.intuit.dto.AddScoreRequestDTO;
import com.intuit.dto.ResponseDTO;
import com.intuit.dto.ResponseStatusCode;
import com.intuit.models.Score;
import com.intuit.services.ScoreServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ScoreController {
    @Autowired
    ScoreServiceImpl scoreService;

    public ResponseDTO<String> addScoreForAPlayer(AddScoreRequestDTO request){
        ResponseDTO<String> response= new ResponseDTO<>();
        try {
            Score score= new Score(request.getUsername(), request.getScoreValue());
            scoreService.addScore(score);
        }
        catch (Exception e) {
            response.setCode(ResponseStatusCode.FAILURE);
            response.setErrorMessage(e.getMessage());
            log.error(e.getMessage());
            return response;
        }

        response.setCode(ResponseStatusCode.SUCCESS);
        response.setData("Successfully Added");
        log.info("Successfully Added " + request.getUsername());
        return response;
    }

    public ResponseDTO<List<Score>> top5(){
        ResponseDTO<List<Score>> response= new ResponseDTO<>();
        long start= System.currentTimeMillis();
        List<Score> scores;
        try {
            scores= scoreService.top5();
        }
        catch (Exception e) {
            response.setCode(ResponseStatusCode.FAILURE);
            response.setErrorMessage(e.getMessage());
            log.error(e.getMessage());
            return response;
        }

        response.setCode(ResponseStatusCode.SUCCESS);
        response.setData(scores);

        long end= System.currentTimeMillis();
        log.info("Took "+ (end-start)+" milliseconds to respond top5 Scoring players");
        return response;
    }

}
