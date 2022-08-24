package com.example.LionKingJPA.domain.comment.service;

import com.example.LionKingJPA.domain.article.entity.Article;
import com.example.LionKingJPA.domain.article.repository.ArticleRepository;
import com.example.LionKingJPA.domain.comment.dto.CommentDto;
import com.example.LionKingJPA.domain.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    private final ArticleRepository articleRepository;

    public Long create(CommentDto commentDto, Long articleId){
        Article findArticle = articleRepository.findById(articleId).orElse(null);
        return commentRepository.save(CommentDto.toEntity(commentDto, findArticle)).getId();
    }

}
