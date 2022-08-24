package com.likelionking.sbbstudy.domain.article.service;

import com.likelionking.sbbstudy.domain.article.domain.Article;
import com.likelionking.sbbstudy.domain.article.domain.ArticleForm;
import com.likelionking.sbbstudy.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;


    public Long write(ArticleForm articleForm) {
        Article article = ArticleForm.toEntity(articleForm);
        Article save = articleRepository.save(article);
        return save.getId();
    }
}
