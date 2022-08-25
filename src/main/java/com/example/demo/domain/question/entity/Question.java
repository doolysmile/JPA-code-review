package com.example.demo.domain.question.entity;

import com.example.demo.domain.answer.entity.Answer;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
public class Question {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDateTime;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    @Builder
    private Question(Long id, String subject, String content, LocalDateTime createDateTime, List<Answer> answerList) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.createDateTime = createDateTime;
        this.answerList = answerList;
    }

    public Question() {

    }
}
