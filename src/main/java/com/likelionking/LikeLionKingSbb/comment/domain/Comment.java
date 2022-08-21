package com.likelionking.LikeLionKingSbb.comment.domain;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import com.likelionking.LikeLionKingSbb.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Comment extends BaseEntity {
    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    private Article article;
}
