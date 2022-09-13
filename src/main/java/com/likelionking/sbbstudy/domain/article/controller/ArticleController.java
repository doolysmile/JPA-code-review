package com.likelionking.sbbstudy.domain.article.controller;


import com.likelionking.sbbstudy.domain.article.entity.Article;
import com.likelionking.sbbstudy.domain.article.dto.ArticleForm;
import com.likelionking.sbbstudy.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;


    /**
     * 게시물 폼 이동
     */
    @GetMapping("/write")
    public String write(ArticleForm articleForm) {
        return "article_form";
    }

    /**
     * 게시물 등록 (Post)
     */
    @PostMapping("/write")
    public String write(@Valid ArticleForm articleForm, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "article_form";
        }
        System.out.println("principal = " + principal.getName());
        Long id = articleService.write(articleForm);
        return "redirect:/article/detail/%d".formatted(id);
    }

    /**
     * 게시글 리스트 조회
     */
    @GetMapping("/list")
    //Todo
    // id -> updateAt으로 변경
    public String getList(Model model, @PageableDefault(sort = "id", size = 20, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Article> list = articleService.getList(pageable);
        model.addAttribute("paging", list);

        return "article_list";
    }

    /**
     * 게시글 조회
     */
    @GetMapping("/detail/{article_id}")
    public String detail(Model model, @PathVariable("article_id") Long id, ArticleForm articleForm){
        Article article = articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_detail";
    }
}
