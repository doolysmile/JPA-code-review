package com.example.demo.domain.answer.service;

import com.example.demo.domain.answer.dto.Create;
import com.example.demo.domain.answer.entity.Answer;
import com.example.demo.domain.answer.repository.AnswerRepository;
import com.example.demo.domain.question.entity.Question;
import com.example.demo.domain.question.repository.QuestionRepository;
import com.example.demo.global.error.exception.DateNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public void create(Create.RequestDto requestDto, Long questionId) {
        Question question =  this.questionRepository.findById(questionId)
                .orElseThrow(() -> new DateNotFoundException("question not found"));

        // dto => entity
        Answer answer = requestDto.toEntity(question);

        answerRepository.save(answer);
    }
}
