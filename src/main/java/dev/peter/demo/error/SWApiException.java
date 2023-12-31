package dev.peter.demo.error;

import java.util.UUID;

import lombok.Getter;

@Getter
public class SWApiException extends RuntimeException {

    private UUID id;

    SWApiException(String message){
        super(message);
        this.id = UUID.randomUUID();
    }

    
    
}
