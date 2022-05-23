package com.example.springbootcruddeneme.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFound(UserNotFoundException userNotFoundException) {
        List<String> detail = new ArrayList<>();
        detail.add(userNotFoundException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("User Not Found", detail);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> userNotNull(UserNotNullException userNotNullException){
        List<String> detail = new ArrayList<>();
        detail.add(userNotNullException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("User Not Null" , detail);
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
