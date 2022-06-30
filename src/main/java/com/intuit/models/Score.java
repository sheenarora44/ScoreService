package com.intuit.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Comparator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Score extends BaseModel implements Comparator<Score> {
    private String username;
    private double score;

    @Override
    public int compare(Score o1, Score o2) {
        return (int)(o2.getScore()-o1.getScore());
    }
}
