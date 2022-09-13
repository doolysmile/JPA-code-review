package com.example.LionKingJPA.domain.article.controller;

import com.example.LionKingJPA.domain.article.dto.ArticleDto;
import com.example.LionKingJPA.domain.article.entity.Article;
import com.example.LionKingJPA.domain.article.service.ArticleService;
import com.example.LionKingJPA.domain.comment.dto.CommentDto;
import com.example.LionKingJPA.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/usr/article")
public class ArticleController {

    private final ArticleService articleService;
    private final UserService userService;

    @GetMapping("/write")
    public String articleCreate(ArticleDto articleDto){

        return "article/article_form";
    }

    @PostMapping("/write")
    public String create(Model model, @Valid ArticleDto articleDto, BindingResult bindingResult, Principal principal){
        System.out.println("articleDto = " + articleDto.getContent());
        if (bindingResult.hasErrors()) {
            return "article/article_form";
        }
//        System.out.println("tttttttttt" + principal.getName());
        articleService.create(articleDto, userService.getUserByEmail(principal.getName()));
        return "redirect:/usr/article/list";
    }

    @GetMapping("/detail/{id}")
    public String articleDetail(@PathVariable("id") Long id, Model model, CommentDto commentDto){
        model.addAttribute("article", articleService.findById(id));
        return "article/article_detail";
    }

    @GetMapping("/list")
    public String articleList(Model model, @RequestParam(defaultValue = "0") int page){


        model.addAttribute("paging", articleService.findAll(page));

        return "article/article_list";
    }

}
