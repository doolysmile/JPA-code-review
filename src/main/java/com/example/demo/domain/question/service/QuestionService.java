package com.example.demo.domain.question.service;

import com.example.demo.domain.question.dto.CreateQuestion;
import com.example.demo.domain.question.dto.LoadQuestion;
import com.example.demo.domain.question.entity.Question;
import com.example.demo.domain.question.repository.QuestionRepository;
import com.example.demo.global.error.exception.DateNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<LoadQuestion.ResponseDto> getList(){
        List<Question> questionList = this.questionRepository.findAll();

        // entity => dto
        return questionList.stream()
                .map(LoadQuestion.ResponseDto::new)
                .toList();
    }

    public LoadQuestion.ResponseDto getQuestion(Long id){
        Question question =  this.questionRepository.findById(id)
                .orElseThrow(() -> new DateNotFoundException("question not found"));

        // entity => dto
        return new LoadQuestion.ResponseDto(question);
    }

    public void save(CreateQuestion.RequestDto requestDto) {
        Question question = requestDto.toEntity();
        questionRepository.save(question);
    }
}
