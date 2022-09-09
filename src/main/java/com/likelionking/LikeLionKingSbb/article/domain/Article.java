package com.likelionking.LikeLionKingSbb.article.domain;

import com.likelionking.LikeLionKingSbb.comment.domain.Comment;
import com.likelionking.LikeLionKingSbb.common.BaseEntity;
import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

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
}
