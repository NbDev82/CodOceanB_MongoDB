package com.example.codoceanbmongo.submitcode.exception;


public class UnsupportedLanguageException extends RuntimeException{
    public UnsupportedLanguageException(String message) {
        super("Language is not supported: " + message);
    }
}
