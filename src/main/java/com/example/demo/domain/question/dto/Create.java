package com.example.demo.domain.question.dto;

import com.example.demo.domain.question.entity.Question;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class Create {
    @Getter
    @Setter
    public static class RequestDto{
        @NotEmpty(message = "제목을 입력하시오.")
        @Size(max = 200, message = "최대 200자까지 가능합니다.")
        private String subject;
        @NotEmpty(message = "내용을 입력하시오.")
        private String content;

        public Question toEntity(){
            return Question.builder()
                    .subject(subject)
                    .content(content)
                    .createdAt(LocalDateTime.now())
                    .build();
        }
    }
}
