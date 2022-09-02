package com.example.demo.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("usr")
public class LocalController {

    @GetMapping("/login")
    public String login() {
        return "login_form";
    }

}
