package com.study.blog.domain.article;

import com.study.blog.domain.comment.Comment;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Article {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(length = 200) // varchar(200)
    private String title;

    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Comment> commentList;
}
