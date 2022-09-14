package com.likelionking.sbbstudy.domain.member.entity;

import com.likelionking.sbbstudy.domain.article.entity.Article;
import com.likelionking.sbbstudy.domain.comment.entity.Comment;
import com.likelionking.sbbstudy.domain.member.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nickname;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(length = 255, unique = true)
    private String email;

    @OneToMany(mappedBy = "member", cascade= CascadeType.ALL)
    private List<Article> arrayList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade= CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();


    public void addComment(Comment comment) {
        this.commentList.add(comment);
    }
}
