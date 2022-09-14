package com.example.LionKingJPA.domain.comment.service;

import com.example.LionKingJPA.domain.article.dto.ArticleDto;
import com.example.LionKingJPA.domain.article.entity.Article;
import com.example.LionKingJPA.domain.article.repository.ArticleRepository;
import com.example.LionKingJPA.domain.comment.dto.CommentDto;
import com.example.LionKingJPA.domain.comment.entity.Comment;
import com.example.LionKingJPA.domain.comment.repository.CommentRepository;
import com.example.LionKingJPA.domain.user.entity.SiteUser;
import com.example.LionKingJPA.global.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    private final ArticleRepository articleRepository;

    public Long create(CommentDto commentDto, Long articleId, SiteUser siteUser){
        Article findArticle = articleRepository.findById(articleId).orElse(null);
        return commentRepository.save(CommentDto.toEntity(commentDto, findArticle, siteUser)).getId();
    }
    public Comment findById(Long id){
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()){
            return comment.get();
        } else {
            throw new DataNotFoundException("comment not found");
        }
    }
    public void modify(Long id, CommentDto commentDto){
        Comment findComment = findById(id);
        findComment.setContent(findComment.getContent());

        commentRepository.save(findComment);
    }

    public void delete(Long id){
        commentRepository.delete(findById(id));
    }
}
