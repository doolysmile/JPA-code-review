package com.example.demo.domain.answer.entity;

import com.example.demo.domain.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @CreatedDate
    private LocalDateTime createDateTime;

    @ManyToOne
    private Question question;

    @Builder
    private Answer(Long id, String content, LocalDateTime createDateTime, Question question) {
        this.id = id;
        this.content = content;
        this.createDateTime = createDateTime;
        this.question = question;
    }


    public Answer() {

    }
}
