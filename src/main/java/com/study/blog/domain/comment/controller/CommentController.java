package com.study.blog.domain.comment.controller;

import com.study.blog.domain.article.domain.Article;
import com.study.blog.domain.article.service.ArticleService;
import com.study.blog.domain.comment.domain.Comment;
import com.study.blog.domain.comment.domain.dto.CommentForm;
import com.study.blog.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final ArticleService articleService;
    private final CommentService commentService;

    @PostMapping("/create/{id}")
    public String create(Model model, @PathVariable long id, @Valid CommentForm commentForm, BindingResult bindingResult){
        Article article = articleService.getArticle(id);

        if (bindingResult.hasErrors()) {
            model.addAttribute("article", article);
            return "article_detail";
        }

        commentService.create(article,commentForm.getContent());
        return "redirect:/article/detail/%d".formatted(id);
    }
}
