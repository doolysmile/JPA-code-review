package com.example.demo.domain.answer;

import com.example.demo.domain.answer.dto.Create;
import com.example.demo.domain.answer.service.AnswerService;
import com.example.demo.domain.question.dto.LoadQuestion;
import com.example.demo.domain.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
    private final AnswerService answerService;
    private final QuestionService questionService;

    @PostMapping("/create/{questionId}")
    public String createAnswer(
            Model model,
            @PathVariable("questionId") Long questionId,
            @Valid Create.RequestDto requestDto,
            BindingResult bindingResult
    ){
        LoadQuestion.ResponseDto question = this.questionService.getQuestion(questionId);

        if(bindingResult.hasErrors()){
            model.addAttribute("question", question);
            return "question_detail";
        }

        answerService.create(requestDto, questionId);

        return String.format("redirect:/question/detail/%s",questionId);
    }
}
