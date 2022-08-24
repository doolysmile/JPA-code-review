package com.likelionking.sbbstudy.domain.article.controller;


import com.likelionking.sbbstudy.domain.article.domain.ArticleForm;
import com.likelionking.sbbstudy.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;


    /**
     * 게시물 폼 이동
     */
    @GetMapping("/write")
    public String write() {
        return "article_form";
    }

    /**
     * 게시물 등록 (Post)
     */
    @PostMapping("/write")
    public String write(@Valid ArticleForm articleForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "article_form";
        }
        Long id = articleService.write(articleForm);
        return "redirect:/article/detail/%d".formatted(id);
    }

}
