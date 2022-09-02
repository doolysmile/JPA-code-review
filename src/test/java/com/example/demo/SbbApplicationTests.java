package com.example.demo;

import com.example.demo.domain.answer.entity.Answer;
import com.example.demo.domain.answer.repository.AnswerRepository;
import com.example.demo.domain.question.dto.Create;
import com.example.demo.domain.question.entity.Question;
import com.example.demo.domain.question.repository.QuestionRepository;
import com.example.demo.domain.question.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SbbApplicationTests {
    @Autowired
    private QuestionService questionService;


    @Test
    void testJpa(){
        for(int i = 1; i <= 300; i++){
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            Create.RequestDto requestDto = new Create.RequestDto();
            requestDto.setSubject(subject);
            requestDto.setContent(content);
            this.questionService.create(requestDto);
        }
    }

}
