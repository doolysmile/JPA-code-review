package com.example.LionKingJPA.domain.article.controller;

import com.example.LionKingJPA.domain.article.dto.ArticleDto;
import com.example.LionKingJPA.domain.article.entity.Article;
import com.example.LionKingJPA.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/usr/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/write")
    public String create(Model model){

        return "article/article_form";
    }

    @PostMapping("/write")
    public String create(ArticleDto articleDto, Model model){
//        System.out.println("articleDto = " + articleDto.getContent());
        articleService.create(articleDto);
        return "article/article_form";
    }

    @GetMapping("/detail/{id}")
    public String articleDetail(@PathVariable("id") Long id, Model model){
        model.addAttribute("article", articleService.findById(id));
        return "article/article_detail";
    }

    @GetMapping("/list")
    public String articleList(Model model){
        List<Article> articleList = articleService.findAll();
        System.out.println("articleList.get(1).getId() = " + articleList.get(1).getId());
        System.out.println("articleList.get(1).getContent() = " + articleList.get(1).getContent());
        model.addAttribute("articleList", articleService.findAll());

        return "article/article_list";
    }

}
