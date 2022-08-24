package com.likelionking.sbbstudy.domain.comment.service;

import com.likelionking.sbbstudy.domain.article.domain.Article;
import com.likelionking.sbbstudy.domain.comment.repository.CommentRepository;
import com.likelionking.sbbstudy.domain.comment.domain.Comment;
import com.likelionking.sbbstudy.domain.comment.domain.CommentForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public void save(Article article, CommentForm commentForm) {

        Comment comment = CommentForm.toEntity(commentForm);
        comment.confirmArticle(article);
        commentRepository.save(comment);

    }
}
