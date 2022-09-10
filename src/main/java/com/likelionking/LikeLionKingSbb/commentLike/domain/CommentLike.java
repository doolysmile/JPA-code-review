package com.likelionking.LikeLionKingSbb.commentLike.domain;

import com.likelionking.LikeLionKingSbb.comment.domain.Comment;
import com.likelionking.LikeLionKingSbb.common.BaseEntity;
import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CommentLike extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Comment comment;

    @ManyToOne
    private SiteUser voter; // 추천인
}
