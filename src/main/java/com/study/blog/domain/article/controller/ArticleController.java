package com.study.blog.domain.article.controller;

import com.study.blog.domain.article.domain.Article;
import com.study.blog.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String getArticle(Model model, @PathVariable("id") long id){
        Article article = articleService.getArticle(id);

        model.addAttribute(article);
        return "article_detail.html";
    }
}
