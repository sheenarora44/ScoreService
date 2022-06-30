package com.intuit.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO<T> {
    public ResponseStatusCode code;
    public String errorMessage;
    public T data;
}
