package com.likelionking.sbbstudy.domain.article.service;

import com.likelionking.sbbstudy.domain.article.entity.Article;
import com.likelionking.sbbstudy.domain.article.dto.ArticleForm;
import com.likelionking.sbbstudy.domain.article.repository.ArticleRepository;
import com.likelionking.sbbstudy.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    @Transactional(readOnly = true)
    //Page<T>을 타입으로 지정하면, 반드시 파라미터로 Pageable을 받아야 한다.
    public Page<Article> getList(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    public Article getArticle(Long id){
        return articleRepository.findById(id).orElseThrow(() ->
                new DataNotFoundException("id번 게시글은 존재하지 않습니다.".formatted(id)));
    }


}
