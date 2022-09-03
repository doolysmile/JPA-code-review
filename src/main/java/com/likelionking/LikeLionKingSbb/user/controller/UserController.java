package com.likelionking.LikeLionKingSbb.user.controller;

import com.likelionking.LikeLionKingSbb.user.domain.UserCreateForm;
import com.likelionking.LikeLionKingSbb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        // 확인용 비밀번호 유효성 검증
        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            // 오류 필드명, 필드에 대한 오류 코드, 필드의 오류 코드 메시지가 존재하지 않을 경우 사용할 오류 메시지
            bindingResult.rejectValue("password2", "ValueMismatch", "확인용 비밀번호가 일치하지 않습니다.");
            return "signup_form";
        }

        userService.create(userCreateForm);

        return "redirect:/";
    }
}
