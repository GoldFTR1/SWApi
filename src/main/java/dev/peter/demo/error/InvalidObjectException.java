package dev.peter.demo.error;

import java.util.Map;

public class InvalidObjectException extends SWApiException{

    private final Map<String,String> constraintViolations;

    public InvalidObjectException(String message, Map<String,String> constraintViolations){
        super(message);
        this.constraintViolations=constraintViolations;
        
    }

    
}
