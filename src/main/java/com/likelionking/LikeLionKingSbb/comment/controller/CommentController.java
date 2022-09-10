package com.likelionking.LikeLionKingSbb.comment.controller;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import com.likelionking.LikeLionKingSbb.article.service.ArticleService;
import com.likelionking.LikeLionKingSbb.comment.domain.Comment;
import com.likelionking.LikeLionKingSbb.comment.dto.CommentDto;
import com.likelionking.LikeLionKingSbb.comment.dto.CommentForm;
import com.likelionking.LikeLionKingSbb.comment.service.CommentService;
import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import com.likelionking.LikeLionKingSbb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

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

    // 댓글 수정폼
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{comment_id}")
    public String modifyForm(Model model, @PathVariable("comment_id") Long commentId, CommentForm commentForm, Principal principal) {
        Comment comment = commentService.findById(commentId);
        if (!comment.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }

        // 기존 값 넣기
        commentForm.setContent(comment.getContent());
        // TODO: commentForm에 Article 넣을지 고려
        model.addAttribute("article_id", comment.getArticle().getId());

        return "comment_modify_form";
    }

    // 댓글 수정
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{comment_id}")
    public String modify(@PathVariable("comment_id") Long commentId, @Valid CommentForm commentForm, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "article_detail";
        }

        Comment comment = commentService.findById(commentId);
        if (!comment.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }

        // Form -> Dto 변환
        CommentDto commentDto = CommentForm.toDto(commentForm);
        commentService.modify(commentDto, comment);

        return "redirect:/article/detail/%d".formatted(comment.getArticle().getId());
    }

    // 댓글 삭제
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{comment_id}")
    public String delete(@PathVariable("comment_id") Long commentId, Principal principal) {
        Comment comment = commentService.findById(commentId);
        if (!comment.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }

        commentService.delete(comment);

        return "redirect:/article/detail/%d".formatted(comment.getArticle().getId());
    }

    // 댓글 좋아요
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/like/{comment_id}")
    public String like(@PathVariable("comment_id") Long commentId, Principal principal) {
        Comment comment = commentService.findById(commentId);
        SiteUser loginUser = userService.findByUsername(principal.getName());

        // TODO: 중복 검사

        commentService.like(comment, loginUser);

        return "redirect:/article/detail/%d".formatted(comment.getArticle().getId());
    }
}
