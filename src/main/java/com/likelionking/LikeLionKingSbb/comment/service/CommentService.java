package com.likelionking.LikeLionKingSbb.comment.service;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import com.likelionking.LikeLionKingSbb.comment.domain.Comment;
import com.likelionking.LikeLionKingSbb.comment.dto.CommentDto;
import com.likelionking.LikeLionKingSbb.comment.repository.CommentRepository;
import com.likelionking.LikeLionKingSbb.commentLike.domain.CommentLike;
import com.likelionking.LikeLionKingSbb.exception.DataNotFoundException;
import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Long save(CommentDto commentDto, Article article, SiteUser author) {
        Comment comment = CommentDto.toEntity(commentDto, article, author);
        Comment saveComment = commentRepository.save(comment);

        return saveComment.getId();
    }

    public Comment findById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(() -> {
            throw new DataNotFoundException("comment not found");
        });
    }

    public void modify(CommentDto commentDto, Comment comment) {
        comment.modify(commentDto);
        commentRepository.save(comment);
    }

    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    @Transactional
    public void like(Comment comment, SiteUser siteUser) {
        CommentLike commentLike = CommentLike.builder()
                .comment(comment)
                .voter(siteUser)
                .build();

        comment.getCommentLikeSet().add(commentLike);
    }
}
