package com.study.blog.domain.comment;

import com.study.blog.domain.article.Article;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    @ManyToOne
    private Article article;
}
