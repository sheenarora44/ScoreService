package com.intuit;

import com.intuit.cache.ScoreCache;
import com.intuit.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@SpringBootApplication
//@ComponentScan(basePackages = {"com.intuit.*"})
public class ScoreServiceApplication {

//	@Autowired
//	ScoreService scoreService;

	public static void main(String[] args) {
		SpringApplication.run(ScoreServiceApplication.class, args);
	}

//	@Bean(name = "ScoreCache")
//	public ScoreCache ScoreCache(){
//		return new ScoreCache(scoreService.findAll());
//	}

}
