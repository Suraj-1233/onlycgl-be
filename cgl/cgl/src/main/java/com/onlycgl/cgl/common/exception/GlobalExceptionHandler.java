package com.onlycgl.cgl.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException ex, WebRequest request) {
        // You can create a custom error response class if needed
        String errorMessage = "Error: " + ex.getMessage();
        String errorCode = "Error Code: " + ex.getErrorCode();

        return new ResponseEntity<>(errorMessage + " (" + errorCode + ")", HttpStatus.BAD_REQUEST);
    }

    // Other exception handlers can be added here
}
