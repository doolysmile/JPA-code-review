package com.likelionking.LikeLionKingSbb.article.service;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import com.likelionking.LikeLionKingSbb.article.repository.ArticleRepository;
import com.likelionking.LikeLionKingSbb.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;


    public List<Article> getList() {
        List<Article> articleList = articleRepository.findAll();

        return articleList;
    }

    public Article getDetail(Long articleId) {
        return findById(articleId);
    }

    public Article findById(Long articleId) {
        // 예외처리
        return articleRepository.findById(articleId).orElseThrow(() -> {
            throw new DataNotFoundException("article not found");
        });
    }
}
