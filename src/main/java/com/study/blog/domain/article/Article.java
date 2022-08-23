package com.study.blog.domain.article;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDateTime;

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
}
