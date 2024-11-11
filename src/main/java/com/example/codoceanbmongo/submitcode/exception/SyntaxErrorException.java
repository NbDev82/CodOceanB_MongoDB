package com.example.codoceanbmongo.submitcode.exception;

public class SyntaxErrorException extends RuntimeException{
    public SyntaxErrorException(String message){
        super(message);
    }
}
