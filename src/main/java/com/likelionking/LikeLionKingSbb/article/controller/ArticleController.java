package com.likelionking.LikeLionKingSbb.article.controller;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import com.likelionking.LikeLionKingSbb.article.dto.ArticleDto;
import com.likelionking.LikeLionKingSbb.article.dto.ArticleForm;
import com.likelionking.LikeLionKingSbb.article.service.ArticleService;
import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import com.likelionking.LikeLionKingSbb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    // 게시글 수정폼
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{article_id}")
    public String modifyForm(@PathVariable("article_id") Long articleId, ArticleForm articleForm, Principal principal) {
        Article article = articleService.findById(articleId);

        // 로그인한 유저가 게시글 작성자인지 검증
        if (!article.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }

        // 기존 값 넣기
        articleForm.setTitle(article.getTitle());
        articleForm.setContent(article.getContent());

        return "article_modify_form";
    }

    // 게시글 수정
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{article_id}")
    public String modify(@PathVariable("article_id") Long articleId, @Valid ArticleForm articleForm, BindingResult bindingResult, Principal principal) {
        // 게시글 폼 입력값 유효성 검증
        if (bindingResult.hasErrors()) {
            return "article_modify_form";
        }

        Article article = articleService.findById(articleId);
        // 로그인한 유저가 게시글 작성자인지 검증
        if (!article.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }

        ArticleDto articleDto = ArticleForm.toDto(articleForm);
        articleService.modify(article, articleDto);

        return "redirect:/article/detail/%d".formatted(articleId);
    }
}
