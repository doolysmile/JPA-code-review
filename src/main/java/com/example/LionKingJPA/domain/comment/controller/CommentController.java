package com.example.LionKingJPA.domain.comment.controller;

import com.example.LionKingJPA.domain.article.entity.Article;
import com.example.LionKingJPA.domain.article.service.ArticleService;
import com.example.LionKingJPA.domain.comment.dto.CommentDto;
import com.example.LionKingJPA.domain.comment.service.CommentService;
import com.example.LionKingJPA.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/usr/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    private final ArticleService articleService;

    private final UserService userService;

    @PostMapping("/write/{article_id}")
    public String create(@PathVariable("article_id") Long articleId, Model model, @Valid CommentDto commentDto, BindingResult bindingResult, Principal principal) {

        Article article = articleService.findById(articleId);

        if(bindingResult.hasErrors()){
            model.addAttribute("article", article);
            return "article/article_detail";
        }

        commentService.create(commentDto, articleId, userService.getUserByEmail(principal.getName()));

        return "redirect:/usr/article/detail/%d".formatted(articleId);
    }
}
