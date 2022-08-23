package com.study.blog.common.exception;

public class ArticleNotFoundException extends DataNotFoundException{

    public ArticleNotFoundException(String message) {
        super(message);
    }
}
