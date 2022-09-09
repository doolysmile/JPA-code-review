package com.likelionking.LikeLionKingSbb.comment.service;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import com.likelionking.LikeLionKingSbb.comment.domain.Comment;
import com.likelionking.LikeLionKingSbb.comment.dto.CommentDto;
import com.likelionking.LikeLionKingSbb.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Long save(CommentDto commentDto, Article article) {
        Comment comment = CommentDto.toEntity(commentDto, article);
        Comment saveComment = commentRepository.save(comment);

        return saveComment.getId();
    }
}
