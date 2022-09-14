package com.example.demo.global.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The passwords were different.")
public class PasswordsDifferentException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public PasswordsDifferentException(String message) {
        super(message);
    }
}
