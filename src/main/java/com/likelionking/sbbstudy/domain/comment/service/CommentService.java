package com.likelionking.sbbstudy.domain.comment.service;

import com.likelionking.sbbstudy.domain.article.entity.Article;
import com.likelionking.sbbstudy.domain.comment.repository.CommentRepository;
import com.likelionking.sbbstudy.domain.comment.entity.Comment;
import com.likelionking.sbbstudy.domain.comment.dto.CommentForm;
import com.likelionking.sbbstudy.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public void save(Article article, CommentForm commentForm, Member member) {

        Comment comment = CommentForm.toEntity(commentForm);
        comment.setMember(member);
        comment.setArticle(article);
        commentRepository.save(comment);

    }
}
