package com.example.codoceanbmongo.submitcode.exception;

public class TimeLimitedException extends RuntimeException{
    public TimeLimitedException(String message){
        super(message);
    }
}
