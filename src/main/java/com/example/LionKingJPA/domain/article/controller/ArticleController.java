package com.example.LionKingJPA.domain.article.controller;

import com.example.LionKingJPA.domain.article.dto.ArticleDto;
import com.example.LionKingJPA.domain.article.entity.Article;
import com.example.LionKingJPA.domain.article.service.ArticleService;
import com.example.LionKingJPA.domain.comment.dto.CommentDto;
import com.example.LionKingJPA.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        articleService.create(articleDto, userService.getUserByEmail(principal.getName()));
        return "redirect:/usr/article/list";
    }

    @GetMapping("/modify/{id}")
    public String modify(ArticleDto articleDto, @PathVariable("id") long id, Principal principal){
        Article article = articleService.findById(id);
        if(!article.getSiteUser().getEmail().equals(principal.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        articleDto.setTitle(article.getTitle());
        articleDto.setContent(articleDto.getContent());

        return "article/article_form";
    }
    @PostMapping("/modify/{id}")
    public String modify(@Valid ArticleDto articleDto,  BindingResult bindingResult,  @PathVariable("id") long id, Principal principal){
        System.out.println(" herehere ");
        if(bindingResult.hasErrors()){
            return "article/article_form";
        }
        Article findArticle = articleService.findById(id);
        if(!findArticle.getSiteUser().getEmail().equals(principal.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        articleService.modify(id, articleDto);

        return String.format("redirect:/usr/article/detail/%s", id);
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
