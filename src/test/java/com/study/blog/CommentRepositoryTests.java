package com.study.blog;

import com.study.blog.domain.article.repository.ArticleRepository;
import com.study.blog.domain.comment.domain.Comment;
import com.study.blog.domain.comment.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CommentRepositoryTests {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Test
    public void Comment를_저장한다(){
        Comment comment = new Comment();
        comment.setContent("안녕하세요");
        comment.setCreateDate(LocalDateTime.now());
        comment.setArticle(articleRepository.findById(1L).get());

        commentRepository.save(comment);

        Comment found = commentRepository.findById(1L).get();

        assertThat(found.getId()).isEqualTo(1L);
        assertThat(found.getContent()).isEqualTo(comment.getContent());
    }

}
