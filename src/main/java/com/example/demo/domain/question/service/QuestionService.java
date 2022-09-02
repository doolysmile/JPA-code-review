package com.example.demo.domain.question.service;

import com.example.demo.domain.question.dto.Create;
import com.example.demo.domain.question.dto.LoadQuestion;
import com.example.demo.domain.question.entity.Question;
import com.example.demo.domain.question.repository.QuestionRepository;
import com.example.demo.global.error.exception.DateNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public Page<Question> getList(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDateTime"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }

    public LoadQuestion.ResponseDto getQuestion(Long id){
        Question question =  this.questionRepository.findById(id)
                .orElseThrow(() -> new DateNotFoundException("question not found"));

        // entity => dto
        return new LoadQuestion.ResponseDto(question);
    }

    public void create(Create.RequestDto requestDto) {
        Question question = requestDto.toEntity();
        questionRepository.save(question);
    }


}
