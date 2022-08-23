package com.study.blog.domain.article.service;

import com.study.blog.common.exception.ArticleNotFoundException;
import com.study.blog.domain.article.domain.Article;
import com.study.blog.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    public List<Article> getList() {
        return articleRepository.findAll();
    }

    public Article getArticle(long id) {
        Optional<Article> article = articleRepository.findById(id);
        return article
                .orElseThrow(() -> new ArticleNotFoundException("%d번 게시글은 존재하지 않습니다.".formatted(id)));
    }
}
