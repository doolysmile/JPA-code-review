package com.likelionking.LikeLionKingSbb.article.repository;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

// 통합테스트(모든 빈)
@SpringBootTest
class ArticleRepositoryTest {
    @Autowired
    private ArticleRepository articleRepository;

    @BeforeEach
    void beforeEach() {
        Article article1 = Article.builder()
                .title("제목1")
                .content("내용1")
                .build();
        articleRepository.save(article1);

        Article article2 = Article.builder()
                .title("제목2")
                .content("내용2")
                .build();
        articleRepository.save(article2);
    }

    @Test
    public void save() {
        Article article1 = Article.builder()
                .title("제목3")
                .content("내용3")
                .build();
        articleRepository.save(article1);
    }

    @Test
    void createSampleData() {
        IntStream.rangeClosed(3, 125).forEach(id -> {
            Article article = Article.builder()
                    .title("제목 %d".formatted(id))
                    .content("내용 %d".formatted(id))
                    .build();

            articleRepository.save(article);
        });
    }
}