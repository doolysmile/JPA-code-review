package com.study.blog.domain.comment.controller;

import com.study.blog.domain.article.domain.Article;
import com.study.blog.domain.article.service.ArticleService;
import com.study.blog.domain.comment.domain.dto.CommentForm;
import com.study.blog.domain.comment.service.CommentService;
import com.study.blog.domain.member.domain.dto.MemberDto;
import com.study.blog.domain.member.service.MemberService;
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
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final ArticleService articleService;
    private final CommentService commentService;

    @PostMapping("/create/{id}")
    public String create(Model model, @PathVariable long id, @Valid CommentForm commentForm, BindingResult bindingResult, Principal principal){
        Article article = articleService.getArticle(id);

        if (bindingResult.hasErrors()) {
            model.addAttribute("article", article);
            return "article_detail";
        }

        commentService.create(article,commentForm.getContent(), principal.getName());
        return "redirect:/article/detail/%d".formatted(id);
    }
}
