package com.raguram.server.exception;

public class UserAlreadyFoundException extends RuntimeException {
    public UserAlreadyFoundException(String message) {
        super(message);
    }
}
