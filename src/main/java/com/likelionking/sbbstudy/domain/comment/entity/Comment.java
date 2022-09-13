package com.likelionking.sbbstudy.domain.comment.entity;


import com.likelionking.sbbstudy.domain.article.entity.Article;
import com.likelionking.sbbstudy.domain.base.BaseTimeEntity;
import com.likelionking.sbbstudy.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
  //  @JoinColumn(name = "article_id") 생략시 자동으로 해당 엔티티명_id로 컬럼 이름이 지정 됨.
    private Article article;

    @ManyToOne
    private Member member;


    public void confirmArticle(Article article){
        this.article = article;
        article.addComment(this);
    }


}
