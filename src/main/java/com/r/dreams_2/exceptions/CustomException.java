package com.r.dreams_2.exceptions;

public class CustomException extends RuntimeException{
    private String message;
    private Integer code;

    public CustomException(String message, Integer code) {
        super(message);
        this.message = message;
        this.code = code;
    }
}
