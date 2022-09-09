package com.likelionking.LikeLionKingSbb.article.controller;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import com.likelionking.LikeLionKingSbb.article.dto.ArticleDto;
import com.likelionking.LikeLionKingSbb.article.dto.ArticleForm;
import com.likelionking.LikeLionKingSbb.article.service.ArticleService;
import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import com.likelionking.LikeLionKingSbb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final UserService userService;

    // 게시글 등록폼
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/write")
    public String createForm(ArticleForm articleForm) {
        return "article_form";
    }

    // 게시글 등록
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/write")
    public String create(@Valid ArticleForm articleForm, BindingResult bindingResult, Principal principal) {
        SiteUser author = userService.findByUsername(principal.getName());

        if (bindingResult.hasErrors()) {
            return "article_form";
        }

        // Form -> Dto 변환
        ArticleDto articleDto = ArticleForm.toDto(articleForm);
        Long articleId = articleService.create(articleDto, author);

        return "redirect:/article/detail/%d".formatted(articleId);
    }

    // 게시글 리스트 조회
    @GetMapping("/list")
    public String getList(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Article> paging = articleService.getList(page);
        model.addAttribute("paging", paging);

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
