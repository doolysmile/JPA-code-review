package com.example.LionKingJPA.domain.comment.service;

import com.example.LionKingJPA.domain.article.service.ArticleService;
import com.example.LionKingJPA.domain.comment.dto.CommentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @Test
    public void 저장(){
        Long beforeSize = Long.valueOf(articleService.findAll().size());
        String content = "commenttest";
        CommentDto commentDto = new CommentDto(content);
        commentService.create(commentDto, beforeSize);
    }
}