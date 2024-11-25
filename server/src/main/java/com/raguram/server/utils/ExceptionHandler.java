package com.raguram.server.utils;

import com.raguram.server.exception.UserAlreadyFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    // To handle validation error
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(400, ex.getBindingResult().getFieldError().getDefaultMessage()));
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(UserAlreadyFoundException.class)
    public ResponseEntity<ErrorResponse> handleUsernameAlreadyExistsException(UserAlreadyFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(422, ex.getLocalizedMessage()));
    }
}