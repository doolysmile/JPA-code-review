package com.study.blog.common.exception;

public class EmailDuplicatedException extends RuntimeException{
    public EmailDuplicatedException(String message) {
        super(message);
    }
}
