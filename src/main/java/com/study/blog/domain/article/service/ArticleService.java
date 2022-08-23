package com.study.blog.domain.article.service;

import com.study.blog.domain.article.domain.Article;
import com.study.blog.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    public List<Article> getList() {
        return articleRepository.findAll();
    }
}
