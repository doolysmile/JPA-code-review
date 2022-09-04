package com.example.LionKingJPA.domain.article.service;

import com.example.LionKingJPA.domain.article.dto.ArticleDto;
import com.example.LionKingJPA.domain.article.entity.Article;
import com.example.LionKingJPA.domain.article.repository.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void 저장(){
////        Long beforeSize = Long.valueOf(articleService.findAll().size());
//        String title = "test2";
//        String content = "content2";
//        ArticleDto articleDto1 = new ArticleDto(title, content);
//        articleService.create(articleDto1);
//        Article findArticle = articleService.findById(beforeSize + 1);
//        assertThat(findArticle.getContent().equals(content));
    }

    @Test
    void creatSamples(){
        boolean runCheck = true;
        if(!runCheck){
            return;
        }
        IntStream.rangeClosed(1, 300).forEach(id -> {
            Article article = new Article();
            article.setTitle("테스트로 추가된 %d번째 글".formatted(id));
            article.setContent("테스트로 추가된 %d번 질문의 내용".formatted(id));

            articleRepository.save(article);
        });
    }

}