package com.study.blog;

import com.study.blog.domain.article.domain.Article;
import com.study.blog.domain.article.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ArticleRepositoryTests {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void ArticleRepository를_통해서_Article을_저장한다(){
        Article article = new Article();
        article.setContent("내용");
        article.setTitle("제목");
        article.setCreateDate(LocalDateTime.now());

        articleRepository.save(article);

        Article found = articleRepository.findById(1L).get();


        assertThat(found.getContent()).isEqualTo(article.getContent());
        assertThat(found.getTitle()).isEqualTo(article.getTitle());
    }
}
