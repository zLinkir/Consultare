package com.consultare.digitalbank.auth.exception;

public class InvalidCredentialsException extends RuntimeException {

    public InvalidCredentialsException() {
        super("auth.invalidCredentials");
    }
}
