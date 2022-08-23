package com.likelionking.LikeLionKingSbb.article.controller;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import com.likelionking.LikeLionKingSbb.article.service.ArticleService;
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

    // 게시글 리스트 조회
    @GetMapping("/list")
    public String getList(Model model) {
        List<Article> articleList = articleService.getList();
        model.addAttribute("articleList", articleList);

        return "article_list";
    }

    // 게시글 상세조회
    @GetMapping("/detail/{article_id}")
    public String getDetail(@PathVariable("article_id") Long articleId, Model model) {
        Article article = articleService.getDetail(articleId);
        model.addAttribute("article", article);

        return "article_detail";
    }
}
