package com.likelionking.LikeLionKingSbb.comment.domain;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import com.likelionking.LikeLionKingSbb.comment.dto.CommentDto;
import com.likelionking.LikeLionKingSbb.commentLike.domain.CommentLike;
import com.likelionking.LikeLionKingSbb.common.BaseEntity;
import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    private Article article;

    @ManyToOne
    private SiteUser author;    // 작성자

    @OneToMany(mappedBy = "voter", cascade = CascadeType.ALL)
    private Set<CommentLike> commentLikeSet;      // 좋아요 목록

    public void modify(CommentDto commentDto) {
        this.content = commentDto.getContent();
    }
}
