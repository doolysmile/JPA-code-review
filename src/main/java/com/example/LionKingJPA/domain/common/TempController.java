package com.example.LionKingJPA.domain.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TempController {
    @RequestMapping("")
    public String index(){
        return "redirect:/usr/article/list";
    }
}
