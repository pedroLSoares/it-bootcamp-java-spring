package com.pedrolsoares.itbootcampw5spring.dealership.exception;

public class RegisterAlreadyExistsException extends RuntimeException{

    private static final long serialVersionUID = -1957137827451037216L;

    public RegisterAlreadyExistsException(String message) {
        super(message);
    }
}
