package com.example.LionKingJPA.domain.article.service;

import com.example.LionKingJPA.domain.article.dto.ArticleDto;
import com.example.LionKingJPA.domain.article.entity.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    @Test
    public void 저장(){
        Long beforeSize = Long.valueOf(articleService.findAll().size());
        String title = "test2";
        String content = "content2";
        ArticleDto articleDto1 = new ArticleDto(title, content);
        articleService.create(articleDto1);
        Article findArticle = articleService.findById(beforeSize + 1);
        assertThat(findArticle.getContent().equals(content));
    }



}