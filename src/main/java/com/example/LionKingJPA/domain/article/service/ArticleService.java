package com.example.LionKingJPA.domain.article.service;

import com.example.LionKingJPA.domain.article.dto.ArticleDto;
import com.example.LionKingJPA.domain.article.entity.Article;
import com.example.LionKingJPA.domain.article.repository.ArticleRepository;
import com.example.LionKingJPA.domain.user.entity.SiteUser;
import com.example.LionKingJPA.global.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Long create(ArticleDto articleDto, SiteUser loginUser){
        return articleRepository.save(ArticleDto.toEntity(articleDto, loginUser)).getId();
    }

    public Article findById(Long id){
        Optional<Article> article = articleRepository.findById(id);
        if(article.isPresent()){
            return article.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    public Page<Article> findAll(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createdAt"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return articleRepository.findAll(pageable);
    }

}
