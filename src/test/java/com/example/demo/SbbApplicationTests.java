package com.example.demo;

import com.example.demo.domain.answer.entity.Answer;
import com.example.demo.domain.answer.repository.AnswerRepository;
import com.example.demo.domain.question.entity.Question;
import com.example.demo.domain.question.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SbbApplicationTests {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void 답변_데이터_생성_후_저장하기(){
        Optional<Question> oq = this.questionRepository.findById(2L);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer a = Answer.builder()
        .content("네 자동으로 생성됩니다.")
        .question(q)
        .createDateTime(LocalDateTime.now())
        .build();

        this.answerRepository.save(a);

    }

    @Test
    void 답변_조회하기(){
        Optional<Answer> oa = this.answerRepository.findById(1L);
        assertTrue(oa.isPresent());
        Answer a = oa.get();
        assertEquals(2, a.getQuestion().getId());
    }

}
