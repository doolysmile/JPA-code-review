package com.study.blog.domain.comment.service;

import com.study.blog.domain.article.domain.Article;
import com.study.blog.domain.comment.domain.Comment;
import com.study.blog.domain.comment.repository.CommentRepository;
import com.study.blog.domain.member.domain.Member;
import com.study.blog.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    public void create(Article article, String content, String memberName) {
        Member member = memberRepository.findByMemberName(memberName).orElseThrow();

        Comment comment = new Comment();
        comment.setArticle(article);
        comment.setCreateDate(LocalDateTime.now());
        comment.setContent(content);
        comment.setAuthor(member);
        article.addComment(comment);

        commentRepository.save(comment);
    }
}
