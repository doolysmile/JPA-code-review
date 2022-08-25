package com.example.demo.domain.question.dto;

import com.example.demo.domain.answer.entity.Answer;
import com.example.demo.domain.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class LoadQuestion {
    @Getter
    @Setter
    static public class ResponseDto{
        private Long id;
        private String subject;
        private String content;
        private LocalDateTime createDateTime;
        private List<Answer> answerList;

        public ResponseDto(Question question) {
            this.id = question.getId();
            this.subject = question.getSubject();
            this.content = question.getContent();
            this.createDateTime = question.getCreateDateTime();
            this.answerList = question.getAnswerList();
        }
    }
}
