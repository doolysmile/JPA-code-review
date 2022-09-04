package com.example.LionKingJPA.domain.user.controller;

import com.example.LionKingJPA.domain.user.dto.UserDto;
import com.example.LionKingJPA.domain.user.service.UserService;
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
@RequestMapping("/usr")
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signUp(UserDto userDto){
        return "user/signUp_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/signUp_form";
        }

        // TODO : service 쪽에 넣기
        if (!userDto.getPassword().equals(userDto.getPasswordCheck())) {
            bindingResult.rejectValue("passwordCheck", "passwordInCorrect", "2개의 패스워드가 일치하지 않습니다.");
            return "user/signUp_form";
        }

        try {
            userService.create(userDto);
        }catch(DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "user/signUp_form";
        }catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "user/signUp_form";
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login_form";
    }
}
