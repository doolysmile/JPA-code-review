package com.likelionking.sbbstudy.domain.article.entity;

import com.likelionking.sbbstudy.domain.base.BaseTimeEntity;
import com.likelionking.sbbstudy.domain.comment.entity.Comment;
import com.likelionking.sbbstudy.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@SuperBuilder // 상속 받고 있으면 superBuilder 사용
@NoArgsConstructor
@AllArgsConstructor
public class Article extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "article", cascade= CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    @ManyToOne
    private Member member;


    public void addComment(Comment comment){
        commentList.add(comment);
    }

    public void setMember(Member member){

        // 작성자가 변경될 일은 없지만 안전하게 하기 위함.
        if(this.member != null){
            this.member.getArrayList().remove(this);
        }
        this.member = member;
        member.getArrayList().add(this);
    }

}
