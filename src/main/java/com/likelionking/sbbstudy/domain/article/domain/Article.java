package com.likelionking.sbbstudy.domain.article.domain;

import com.likelionking.sbbstudy.domain.base.BaseTimeEntity;
import com.likelionking.sbbstudy.domain.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Builder
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
