package com.study.blog.domain.comment.service;

import com.study.blog.domain.article.domain.Article;
import com.study.blog.domain.comment.domain.Comment;
import com.study.blog.domain.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    public void create(Article article, String content) {

        Comment comment = new Comment();
        comment.setArticle(article);
        comment.setCreateDate(LocalDateTime.now());
        comment.setContent(content);
        article.addComment(comment);

        commentRepository.save(comment);
    }
}
