package com.likelionking.sbbstudy.domain.article.service;

import com.likelionking.sbbstudy.domain.article.domain.Article;
import com.likelionking.sbbstudy.domain.article.domain.ArticleForm;
import com.likelionking.sbbstudy.domain.article.repository.ArticleRepository;
import com.likelionking.sbbstudy.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;


    public Long write(ArticleForm articleForm) {
        Article article = ArticleForm.toEntity(articleForm);
        Article save = articleRepository.save(article);
        return save.getId();
    }

    public List<Article> getList() {
        return articleRepository.findAll();
    }
    
    public Article getArticle(Long id){
        return articleRepository.findById(id).orElseThrow(() ->
                new DataNotFoundException("id번 게시글은 존재하지 않습니다.".formatted(id)));
    }


}
