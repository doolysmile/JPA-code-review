package com.example.demo.domain.user.controller;

import com.example.demo.domain.user.dto.SignUp;
import com.example.demo.domain.user.service.SiteUserService;
import com.example.demo.global.error.exception.PasswordsDifferentException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
@RequestMapping("usr")
public class SiteUserController {
    private final SiteUserService siteUserService;

    @GetMapping("signup")
    public String signUp(SignUp.requestDto requestDto){
        return "signup_form";
    }

    @PostMapping("signup")
    public String signup(
            @Valid SignUp.requestDto requestDto,
            BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()){
            return "signup_form";
        }

        // TODO try catch 제거
        try{
            siteUserService.signUp(requestDto);
        } catch(PasswordsDifferentException e){ // 비밀번호 불일치
            bindingResult.reject("PasswordsDifferentException", e.getMessage());
            return "signup_form";
        } catch(DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup_form";
        } catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "알 수 없는 에러 발생");
            return "signup_form";
        }

        return "redirect:/";
    }
}
