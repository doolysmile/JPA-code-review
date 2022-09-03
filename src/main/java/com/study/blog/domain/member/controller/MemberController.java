package com.study.blog.domain.member.controller;

import com.study.blog.domain.member.domain.dto.MemberCreateForm;
import com.study.blog.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private MemberService memberService;

    @GetMapping("/create")
    public String create(MemberCreateForm memberCreateForm){
        return "member_create";
    }
}
