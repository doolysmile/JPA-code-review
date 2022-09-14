package com.example.LionKingJPA.domain.comment.controller;

import com.example.LionKingJPA.domain.article.dto.ArticleDto;
import com.example.LionKingJPA.domain.article.entity.Article;
import com.example.LionKingJPA.domain.article.service.ArticleService;
import com.example.LionKingJPA.domain.comment.dto.CommentDto;
import com.example.LionKingJPA.domain.comment.entity.Comment;
import com.example.LionKingJPA.domain.comment.service.CommentService;
import com.example.LionKingJPA.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    @GetMapping("/modify/{id}")
    public String modify(CommentDto commentDto, @PathVariable("id") long id, Principal principal){
        Comment comment = commentService.findById(id);
        if(!comment.getSiteUser().getEmail().equals(principal.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }

        commentDto.setContent(commentDto.getContent());
        return "comment/comment_form";
    }
    @PostMapping("/modify/{id}")
    public String modify(@Valid CommentDto commentDto,  BindingResult bindingResult,  @PathVariable("id") long id, Principal principal){
        System.out.println(" herehere ");
        if(bindingResult.hasErrors()){
            return "comment/comment_form";
        }
        Comment findComment = commentService.findById(id);
        if(!findComment.getSiteUser().getEmail().equals(principal.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        commentService.modify(id, commentDto);

        return String.format("redirect:/usr/article/detail/%s", findComment.getArticle().getId());
    }

    @GetMapping("/delete/{id}")
    public String commentDelete(Principal principal, @PathVariable("id") Long id){
        Comment findComment = commentService.findById(id);
        if(!findComment.getSiteUser().getEmail().equals(principal.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        commentService.delete(id);
        return String.format("redirect:/usr/article/detail/%s", findComment.getArticle().getId());
    }
}
