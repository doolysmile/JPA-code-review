package com.example.LionKingJPA.domain.comment.controller;

import com.example.LionKingJPA.domain.comment.dto.CommentDto;
import com.example.LionKingJPA.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usr/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/write/{article_id}")
    public String create(@PathVariable("article_id") Long articleId, CommentDto commentDto){

        commentService.create(commentDto, articleId);

        return "redirect:/usr/article/detail/%d".formatted(articleId);
    }
}
