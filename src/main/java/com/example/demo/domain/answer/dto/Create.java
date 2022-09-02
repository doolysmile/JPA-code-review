package com.example.demo.domain.answer.dto;

import com.example.demo.domain.answer.entity.Answer;
import com.example.demo.domain.question.entity.Question;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public class Create {
    @Getter
    @Setter
    public static class RequestDto{
        private Long id;
        @NotEmpty(message = "내용을 입력하시오.")
        private String content;

        public Answer toEntity(Question question){
            return Answer.builder()
                    .id(id)
                    .content(content)
                    .createDateTime(LocalDateTime.now())
                    .question(question)
                    .build();
        }
    }
}
