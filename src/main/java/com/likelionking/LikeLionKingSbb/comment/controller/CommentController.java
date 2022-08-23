package com.likelionking.LikeLionKingSbb.comment.controller;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import com.likelionking.LikeLionKingSbb.article.service.ArticleService;
import com.likelionking.LikeLionKingSbb.comment.dto.CommentForm;
import com.likelionking.LikeLionKingSbb.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final ArticleService articleService;

    // 답변 등록
    @PostMapping("/write/{article_id}")
    public String getDetail(@PathVariable("article_id") Long articleId, @Valid CommentForm commentForm, BindingResult bindingResult) {
        Article article = articleService.findById(articleId);
        System.out.println("됨");
        if (bindingResult.hasErrors()) {
            return "article_detail";
        }

        commentService.save(commentForm, article);

//        return "redirect:/article/detail/%d".formatted(articleId);
        return "redirect:/article/list";
    }
}
