package com.intuit.cache;

import com.intuit.models.Score;
import com.intuit.repositories.ScoreRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Synchronization;
import java.util.*;

@Component
@EnableScheduling
public class ScoreCache {
    private  Set<Score> set;

    @Autowired
    ScoreRepository scoreRepository;

    @Bean(initMethod = "init")
    public void init(){
        List<Score> list= scoreRepository.findAll();
        set= new TreeSet<Score>(Comparator.comparingDouble(a->-1*a.getScore()));
        set.addAll(list);
        set= Collections.synchronizedSet(set);
    }

    public Set<Score> getSet(){
        return set;
    }

}

