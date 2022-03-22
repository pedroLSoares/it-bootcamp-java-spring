package com.pedrolsoares.itbootcampw5spring.dealership.exception.handler;

import com.pedrolsoares.itbootcampw5spring.dealership.exception.RegisterAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RepositoryExceptionHandler {

    @ExceptionHandler(value = RegisterAlreadyExistsException.class)
    protected ResponseEntity<Object> handleExistentRegister(RegisterAlreadyExistsException ex){
        String bodyOfResponse = ex.getMessage();
        return ResponseEntity.badRequest().body(bodyOfResponse);
    }
}
