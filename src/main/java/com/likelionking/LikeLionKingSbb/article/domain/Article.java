package com.likelionking.LikeLionKingSbb.article.domain;

import com.likelionking.LikeLionKingSbb.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Article extends BaseEntity {
    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
}
