package com.intuit.ScoreService;

import com.intuit.controllers.ScoreController;
import com.intuit.dto.AddScoreRequestDTO;
import com.intuit.dto.ResponseDTO;
import com.intuit.dto.ResponseStatusCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@Slf4j
public class ScoreTests {
    @Autowired
    ScoreController scoreController;

    @Test
    void Test(){
//        String player= "Player";
//        int number=2000;
//        for(int i=0; i<number; i++){
//            AddScoreRequestDTO request= new AddScoreRequestDTO(player+i, Math.random());
//            ResponseDTO<String> response= scoreController.addScoreForAPlayer(request);
//            if(response.getCode()== ResponseStatusCode.SUCCESS){
//                log.info(response.getData());
//            }
//            else{
//                log.error(response.getErrorMessage());
//            }
//        }

        log.info("*****LeaderBoard*****");
        scoreController.top5().getData().forEach(a->log.info(a.toString()));

        scoreController.addScoreForAPlayer(new AddScoreRequestDTO("Mike", 1));

        log.info("*****LeaderBoard*****");
        scoreController.top5().getData().forEach(a->log.info(a.toString()));

        scoreController.addScoreForAPlayer(new AddScoreRequestDTO("Phil", 2));


        log.info("*****LeaderBoard*****");
        scoreController.top5().getData().forEach(a->log.info(a.toString()));
    }
}
