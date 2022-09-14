package com.likelionking.sbbstudy.domain.comment.controller;


import com.likelionking.sbbstudy.domain.article.entity.Article;
import com.likelionking.sbbstudy.domain.article.service.ArticleService;
import com.likelionking.sbbstudy.domain.comment.service.CommentService;
import com.likelionking.sbbstudy.domain.comment.dto.CommentForm;
import com.likelionking.sbbstudy.domain.member.entity.Member;
import com.likelionking.sbbstudy.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@RequestMapping("/comment")
@RequiredArgsConstructor
@Service
public class CommentController {

    @Autowired
    private final CommentService commentService;

    @Autowired
    private final ArticleService articleService;

    private final MemberService memberService;

    @PostMapping("write/{article_id}")
    public String write(@PathVariable("article_id") Long id, @Valid CommentForm commentForm, BindingResult bindingResult, Principal principal) {

        String memberEmail = null;
        Member member = null;

        Article article = articleService.getArticle(id);
        if (bindingResult.hasErrors()) {
//            return ""
        }

        // 로그인이 된 경우
        if(principal != null && principal.getName() != null){
            memberEmail = principal.getName();
            member = memberService.find(memberEmail);
        }

        commentService.save(article, commentForm, member);

        return "redirect:/article/detail/%d".formatted(id);

    }
}
