package com.likelionking.sbbstudy.domain.member.controller;

import com.likelionking.sbbstudy.domain.member.entity.Member;
import com.likelionking.sbbstudy.domain.member.service.KaKaoService;
import com.likelionking.sbbstudy.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    /**
     * TODO
     * SpringSecurity 추가
     */

    @Value("${custom.clientId}")
    private String clientId;

    @Autowired
    KaKaoService kaKaoService;

    @Autowired
    MemberService memberService;

    @GetMapping("/oauth")
    public String kakaoConnect() {
        System.out.println("clientId = " + clientId);
        StringBuffer url = new StringBuffer();
        url.append("https://kauth.kakao.com/oauth/authorize?");
        url.append("client_id=" + clientId);
        url.append("&redirect_uri=http://localhost:8080/member/kakao");
        url.append("&response_type=code");

        return "redirect:" + url.toString();
    }

    @GetMapping("/do")
    public String loginPage(HttpSession httpSession)
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
    public String kakaoCallback(@RequestParam String code, Model model) throws IOException {

        System.out.println("code = " + code);
        String access_token = kaKaoService.getToken(code);
        Map<String, Object> userInfo = kaKaoService.getUserInfo(access_token);
        Member member = Member.builder()
                .nickname(userInfo.get("nickname").toString())
                .email(userInfo.get("email").toString())
                .build();

        memberService.create(member);

        //ci는 비즈니스 전환후 검수신청 -> 허락받아야 수집 가능
//        return "home";
        return "redirect:/article/list";
    }



}
