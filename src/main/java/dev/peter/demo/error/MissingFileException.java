package dev.peter.demo.error;

import lombok.Getter;

@Getter
public class MissingFileException extends SWApiException {

    private static final String ERROR_MESSAGE = "Missing required file upload";
    private String entityClass;
    private String fileUploadKey;

   public   MissingFileException(String entityClass, String fileUploadKey){
        super(ERROR_MESSAGE);
        this.entityClass=entityClass;
        this.fileUploadKey = fileUploadKey;
    }
    
}
