package com.consultare.digitalbank.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final LocalDateTime timestamp;
    private final Integer status;
    private final String code;
    private final String message;
    private final String path;
    private final Map<String,String> fields;

}

