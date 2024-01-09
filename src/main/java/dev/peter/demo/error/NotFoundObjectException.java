package dev.peter.demo.error;

import lombok.Getter;

@Getter
public class NotFoundObjectException extends SWApiException {

    private static final String ERROR_MESSAGE = "Object Not Found";
    private String entityClass;
    private String entityId;

    public NotFoundObjectException(String entityClass, String entityId){
        super(ERROR_MESSAGE);
        this.entityClass=entityClass;
        this.entityId=entityId;

    }

    
}
