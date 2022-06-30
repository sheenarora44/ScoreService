package com.intuit.repositories;

import com.intuit.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
    List<Score> findTop5ByOrderByScoreDesc();
    Score save(Score score);

    Score findByUsername(String username);
}
