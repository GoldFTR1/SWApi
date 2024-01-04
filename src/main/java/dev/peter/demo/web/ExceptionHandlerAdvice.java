package dev.peter.demo.web;

import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.peter.demo.error.InvalidObjectException;
import dev.peter.demo.error.MissingFileException;
import dev.peter.demo.error.NotFoundObjectException;
import dev.peter.demo.error.SWApiException;
import lombok.Builder;
import lombok.Data;

@RestControllerAdvice
public class ExceptionHandlerAdvice {


    @ExceptionHandler(NotFoundObjectException.class)
    public ResponseEntity<SWApiHttpException> entityNotFound(NotFoundObjectException ex){
        SWApiHttpException httpEx = SWApiHttpException.builder().errorId(ex.getId()).message(ex.getMessage() + ". Not found ID: " + ex.getEntityId())
        .clazz(ex.getEntityClass()).build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(httpEx);
    }

    @ExceptionHandler(MissingFileException.class)
    public ResponseEntity<SWApiHttpException> missingUpload(MissingFileException ex){
        SWApiHttpException httpEx = SWApiHttpException.builder().errorId(ex.getId()).message(ex.getMessage() + ". File should be at key: " + ex.getFileUploadKey())
        .clazz(ex.getEntityClass()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(httpEx);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<SWApiHttpException> methodNotAllowed(HttpRequestMethodNotSupportedException ex){
        SWApiHttpException httpEx = SWApiHttpException.builder().errorId(UUID.randomUUID())
        .message("Method not allowed: " + ex.getMethod()).build();

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(httpEx);
    }

    @ExceptionHandler(InvalidObjectException.class)
    public ResponseEntity<SWApiHttpException> invalidObject(InvalidObjectException e){
        SWApiHttpException httpEx = SWApiHttpException.builder().errorId(e.getId())
        .message(e.getMessage()).errors(e.getConstraintViolations()).build();

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(httpEx);  
    }

    public ResponseEntity<SWApiHttpException> illegalArgument(IllegalArgumentException e){
        SWApiHttpException httpEx = SWApiHttpException.builder().errorId(UUID.randomUUID())
        .message(e.getMessage()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(httpEx);
    }

    @Data
    @Builder
    public static class SWApiHttpException{
        private UUID errorId;
        private String message;
        private String clazz;
        private Map<String, String> errors;

    }
    
}
