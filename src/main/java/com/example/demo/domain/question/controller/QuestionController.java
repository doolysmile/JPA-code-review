package com.example.demo.domain.question.controller;

import com.example.demo.domain.answer.dto.CreateAnswer;
import com.example.demo.domain.question.dto.CreateQuestion;
import com.example.demo.domain.question.dto.LoadQuestion;
import com.example.demo.domain.question.entity.Question;
import com.example.demo.domain.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("list")
    public String list(Model model){
        List<LoadQuestion.ResponseDto> questionList = this.questionService.getList();

        model.addAttribute("questionList", questionList);

        return "question_list";
    }

    @GetMapping("detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id){
        LoadQuestion.ResponseDto question = this.questionService.getQuestion(id);

        model.addAttribute("question", question);
        model.addAttribute("requestDto", new CreateAnswer.RequestDto());

        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(Model model){
        model.addAttribute("requestDto", new CreateQuestion.RequestDto());
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(
            Model model,
            @Valid CreateQuestion.RequestDto requestDto,
            BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()){
            return "question_form";
        }

        questionService.save(requestDto);
        return "redirect:/question/list";
    }
}
