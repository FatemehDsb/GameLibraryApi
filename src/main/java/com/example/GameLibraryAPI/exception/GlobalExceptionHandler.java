package com.example.GameLibraryAPI.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

   @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound (ResourceNotFoundException ex){
       return buildResponseEntity("Resource not found ! ", ex.getMessage(), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequest ( BadRequestException ex){
       return buildResponseEntity("Bad Request ! ", ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());

        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(e -> {
            String field = e.getPropertyPath().toString();
            errors.put(field, e.getMessage());
        });
        body.put("errors", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());

        Map<String, String> errors = new HashMap<>();
        for (FieldError e : ex.getBindingResult().getFieldErrors()) {
            errors.put(e.getField(), e.getDefaultMessage());
        }

        body.put("errors", errors);

        return new ResponseEntity<>(body, status);
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