package dev.peter.demo.error;

import lombok.Getter;

@Getter
public class AuthenticationFailedException extends SWApiException {

    private static final String ERROR_MESSAGE = "Failed to authenticate";
    private String concreteError;

    public AuthenticationFailedException(String concreteError) {
        super(ERROR_MESSAGE);
        this.concreteError = concreteError;
    }
}
