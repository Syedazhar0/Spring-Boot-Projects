package com.tcs.restex.exceptionhandling;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
// this is a separate class to handle the rest exceptions this code you can copy from the chatgpt
// enter MethodArgumentNotValidException code

// this is concept of AOP stands for Aspect-Oriented Programming.
//Aspect-Oriented Programming is a programming paradigm that enables
//modularization of cross-cutting concerns, such as logging, security, transaction management, 
//and error handling, which are often spread across different parts of an application Aop
// separate business logic and crosscutting like security transaction

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body("Validation failure: " + errors);
    }
}
 