package com.example.LionKingJPA.domain.comment.entity;

import com.example.LionKingJPA.domain.article.entity.Article;
import com.example.LionKingJPA.domain.user.entity.SiteUser;
import com.example.LionKingJPA.global.common.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment extends BaseEntity {
    @Column
    private String content;

    @ManyToOne
    private Article article;

    @ManyToOne
    private SiteUser siteUser;
}
