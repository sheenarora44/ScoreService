package com.intuit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
public class AddScoreRequestDTO {
    private String username;
    private double scoreValue;
}
