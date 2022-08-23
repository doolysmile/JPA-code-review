package com.likelionking.LikeLionKingSbb.comment.controller;

import com.likelionking.LikeLionKingSbb.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // 답변 등록
    @GetMapping("/{comment_id}")
    public String getDetail(@PathVariable("comment_id") Long commentId) {
        
        return "";
    }
}
