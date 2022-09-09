package com.likelionking.LikeLionKingSbb.comment.controller;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import com.likelionking.LikeLionKingSbb.article.service.ArticleService;
import com.likelionking.LikeLionKingSbb.comment.dto.CommentDto;
import com.likelionking.LikeLionKingSbb.comment.dto.CommentForm;
import com.likelionking.LikeLionKingSbb.comment.service.CommentService;
import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import com.likelionking.LikeLionKingSbb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final ArticleService articleService;
    private final UserService userService;

    // 답변 등록
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/write/{article_id}")
    public String getDetail(@PathVariable("article_id") Long articleId, @Valid CommentForm commentForm, BindingResult bindingResult, Principal principal) {
        SiteUser author = userService.findByUsername(principal.getName());
        Article article = articleService.findById(articleId);

        if (bindingResult.hasErrors()) {
            return "article_detail";
        }

        // Form -> Dto 변환
        CommentDto commentDto = CommentForm.toDto(commentForm);
        commentService.save(commentDto, article, author);

        return "redirect:/article/detail/%d".formatted(articleId);
    }
}
