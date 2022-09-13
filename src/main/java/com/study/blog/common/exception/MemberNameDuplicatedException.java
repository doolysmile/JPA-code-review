package com.study.blog.common.exception;

public class MemberNameDuplicatedException extends RuntimeException {
    public MemberNameDuplicatedException(String message) {
        super(message);
    }
}
