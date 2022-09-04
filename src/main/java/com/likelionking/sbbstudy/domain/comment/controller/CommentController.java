package com.likelionking.sbbstudy.domain.comment.controller;


import com.likelionking.sbbstudy.domain.article.entity.Article;
import com.likelionking.sbbstudy.domain.article.service.ArticleService;
import com.likelionking.sbbstudy.domain.comment.service.CommentService;
import com.likelionking.sbbstudy.domain.comment.dto.CommentForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/comment")
@RequiredArgsConstructor
@Service
public class CommentController {

    private final CommentService commentService;
    private final ArticleService articleService;

    @PostMapping("write/{article_id}")
    public String write(@PathVariable("article_id") Long id, @Valid CommentForm commentForm, BindingResult bindingResult) {
        Article article = articleService.getArticle(id);
        if (bindingResult.hasErrors()) {
//            return ""
        }

        commentService.save(article, commentForm);

        return "redirect:/article/detail/%d".formatted(id);

    }
}
