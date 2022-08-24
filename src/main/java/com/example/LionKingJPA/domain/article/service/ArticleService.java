package com.example.LionKingJPA.domain.article.service;

import com.example.LionKingJPA.domain.article.dto.ArticleDto;
import com.example.LionKingJPA.domain.article.entity.Article;
import com.example.LionKingJPA.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Long create(ArticleDto articleDto){
        return articleRepository.save(ArticleDto.toEntity(articleDto)).getId();
    }

    public Article findById(Long id){
        return articleRepository.findById(id).orElse(null);
    }

    public List<Article> findAll(){
        return articleRepository.findAll();
    }

}
