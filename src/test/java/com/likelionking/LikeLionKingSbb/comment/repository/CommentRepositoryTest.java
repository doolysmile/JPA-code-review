package com.likelionking.LikeLionKingSbb.comment.repository;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import com.likelionking.LikeLionKingSbb.article.repository.ArticleRepository;
import com.likelionking.LikeLionKingSbb.comment.domain.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentRepositoryTest {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentRepository commentRepository;

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
    void save() {
        Article article = articleRepository.findById(1L).orElse(null);
        Comment comment = Comment.builder()
                .content("답변1")
                .article(article)
                .build();
        commentRepository.save(comment);
    }
}