package com.example.LionKingJPA.domain.article.service;

import com.example.LionKingJPA.domain.article.dto.ArticleDto;
import com.example.LionKingJPA.domain.article.entity.Article;
import com.example.LionKingJPA.domain.article.repository.ArticleRepository;
import com.example.LionKingJPA.global.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Long create(ArticleDto articleDto){
        return articleRepository.save(ArticleDto.toEntity(articleDto)).getId();
    }

    public Article findById(Long id){
        Optional<Article> article = articleRepository.findById(id);
        if(article.isPresent()){
            return article.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    public List<Article> findAll(){
        return articleRepository.findAll();
    }

}
