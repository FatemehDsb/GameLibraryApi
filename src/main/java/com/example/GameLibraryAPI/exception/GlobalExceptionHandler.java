package com.example.GameLibraryAPI.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

   @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound (ResourceNotFoundException ex){
       return buildResponseEntity("Resource not found", ex.getMessage(), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequest ( BadRequestException ex){
       return buildResponseEntity("Bad Request", ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> buildResponseEntity(String error, String message, HttpStatus httpStatus) {
       Map<String, Object> body = new HashMap<>();
       body.put("error", error);
       body.put("message", message);
       body.put("status", httpStatus);
       body.put("Timestamp", LocalDate.now());
       return new ResponseEntity<>(body, httpStatus);
    }
}