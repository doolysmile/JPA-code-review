package com.likelionking.sbbstudy.domain.article.domain;

import com.likelionking.sbbstudy.domain.base.BaseTimeEntity;
import com.likelionking.sbbstudy.domain.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@SuperBuilder // 상속 받고 있으면 superBuilder 사용
@NoArgsConstructor
@AllArgsConstructor
public class Article extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "article", cascade= CascadeType.REMOVE)
    private List<Comment> commentList = new ArrayList<>();


    public void addComment(Comment comment){
        commentList.add(comment);
    }

}
