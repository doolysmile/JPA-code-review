package com.example.LionKingJPA.domain.article.controller;

import com.example.LionKingJPA.domain.article.dto.ArticleDto;
import com.example.LionKingJPA.domain.article.entity.Article;
import com.example.LionKingJPA.domain.article.service.ArticleService;
import com.example.LionKingJPA.domain.comment.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/usr/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/write")
    public String articleCreate(ArticleDto articleDto){

        return "article/article_form";
    }

    @PostMapping("/write")
    public String create(Model model, @Valid ArticleDto articleDto, BindingResult bindingResult){
        System.out.println("articleDto = " + articleDto.getContent());
        if (bindingResult.hasErrors()) {
            return "article/article_form";
        }
        articleService.create(articleDto);
        return "redirect:/usr/article/list";
    }

    @GetMapping("/detail/{id}")
    public String articleDetail(@PathVariable("id") Long id, Model model, CommentDto commentDto){
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
