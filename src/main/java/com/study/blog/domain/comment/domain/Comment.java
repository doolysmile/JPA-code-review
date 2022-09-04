package com.study.blog.domain.comment.domain;

import com.study.blog.domain.article.domain.Article;
import com.study.blog.domain.member.domain.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    @ManyToOne
    private Article article;

    @ManyToOne
    private Member author;
}
