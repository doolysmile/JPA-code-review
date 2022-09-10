package com.likelionking.LikeLionKingSbb.article.domain;

import com.likelionking.LikeLionKingSbb.ArticleLike.domain.ArticleLike;
import com.likelionking.LikeLionKingSbb.article.dto.ArticleDto;
import com.likelionking.LikeLionKingSbb.comment.domain.Comment;
import com.likelionking.LikeLionKingSbb.common.BaseEntity;
import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter     // TODO: entity setter 대신 builder 사용하기(삭제)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Article extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    private SiteUser author;    // 작성자

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Comment> commentList;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<ArticleLike> articleLikeList;      // 좋아요 목록

    public Article modify(ArticleDto articleDto) {
        this.setTitle(articleDto.getTitle());
        this.setContent(articleDto.getContent());

        return this;
    }
}
