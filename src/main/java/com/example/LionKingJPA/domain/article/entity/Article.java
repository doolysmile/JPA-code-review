package com.example.LionKingJPA.domain.article.entity;

import com.example.LionKingJPA.domain.comment.entity.Comment;
import com.example.LionKingJPA.global.common.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Article extends BaseEntity {
    @Column
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "article")
    private List<Comment> commentList;
}
