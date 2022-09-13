package com.study.blog.common.exception;

public class MemberNotFoundException extends DataNotFoundException{
    public MemberNotFoundException(String message) {
        super(message);
    }
}
