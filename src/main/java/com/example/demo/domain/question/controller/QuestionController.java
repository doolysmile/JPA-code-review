package com.example.demo.domain.question.controller;

import com.example.demo.domain.question.dto.Create;
import com.example.demo.domain.question.dto.LoadQuestion;
import com.example.demo.domain.question.entity.Question;
import com.example.demo.domain.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("list")
    public  String list(
            Model model,
            @RequestParam(value="page", defaultValue = "0") int page
    ){
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
        return "question_list";
    }

    @GetMapping("detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id){
        LoadQuestion.ResponseDto question = this.questionService.getQuestion(id);

        model.addAttribute("question", question);
        model.addAttribute("requestDto", new com.example.demo.domain.answer.dto.Create.RequestDto());

        return "question_detail";
    }

    @GetMapping("create")
    public String questionCreate(Model model){
        model.addAttribute("requestDto", new Create.RequestDto());
        return "question_form";
    }

    @PostMapping("create")
    public String questionCreate(
            Model model,
            @Valid Create.RequestDto requestDto,
            BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()){
            return "question_form";
        }

        questionService.create(requestDto);
        return "redirect:/question/list";
    }


}
