package com.likelionking.sbbstudy.domain.member.controller;

import com.likelionking.sbbstudy.domain.member.service.KaKaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class KaKaoController {

    @Autowired
    KaKaoService kaKaoService;

    @GetMapping("/oauth")
    public String kakaoConnet() {

        StringBuffer url = new StringBuffer();
        url.append("https://kauth.kakao.com/oauth/authorize?");
        url.append("client_id=" + "3327cd22ef6585c38612b166ce59d9c6");
        url.append("&redirect_uri=http://localhost:8080/member/kakao");
        url.append("&response_type=code");

        return "redirect:" + url.toString();
    }

    @GetMapping("/do")
    public String loginPage()
    {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        kaKaoService.kakaoLogout((String)session.getAttribute("access_Token"));
        session.removeAttribute("access_Token");
        session.removeAttribute("userId");
        return "index";
    }



    @GetMapping("/kakao")
    public String getCI(@RequestParam String code, Model model) throws IOException {

        System.out.println("code = " + code);
        String access_token = kaKaoService.getToken(code);
        Map<String, Object> userInfo = kaKaoService.getUserInfo(access_token);
        model.addAttribute("code", code);
        model.addAttribute("access_token", access_token);
        model.addAttribute("userInfo", userInfo);

        //ci는 비즈니스 전환후 검수신청 -> 허락받아야 수집 가능
        return "home";
    }



}
