package com.study.blog.domain.member.controller;

import com.study.blog.domain.member.domain.dto.MemberCreateForm;
import com.study.blog.domain.member.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/create")
    public String create(MemberCreateForm memberCreateForm){
        return "member_create";
    }

    @PostMapping("/create")
    public String create(@Valid MemberCreateForm memberCreateForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "member_create";
        }

        if (!memberCreateForm.getPassword1().equals(memberCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "member_create";
        }

        memberService.create(memberCreateForm.toDto());

        return "redirect:/";
    }

    @GetMapping("login")
    public String login(){
        return "login_form";
    }
}
