package com.study.blog.domain.article.controller;

import com.study.blog.domain.article.domain.Article;
import com.study.blog.domain.article.domain.dto.ArticleForm;
import com.study.blog.domain.article.service.ArticleService;
import com.study.blog.domain.comment.domain.dto.CommentForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/list")
    public String getList(Model model){
        List<Article> articleList = articleService.getList();

        model.addAttribute(articleList);
        return "article_list.html";
    }

    @GetMapping("/detail/{id}")
    public String getArticle(Model model, @PathVariable("id") long id, CommentForm commentForm){
        Article article = articleService.getArticle(id);

        model.addAttribute(article);
        return "article_detail.html";
    }

    @GetMapping("/create")
    public String showCreate(ArticleForm articleForm){
        return "article_create";
    }

    @PostMapping("/create")
    public String create(Model model, @Valid ArticleForm articleForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "article_create";
        }

        articleService.create(articleForm.getTitle(),articleForm.getContent());

        return "redirect:/article/list";
    }
}
