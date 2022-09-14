package com.likelionking.sbbstudy.domain.member.service;

import com.likelionking.sbbstudy.domain.member.dto.KaKaoUserInto;
import com.likelionking.sbbstudy.domain.member.dto.MemberDto;
import com.likelionking.sbbstudy.domain.member.entity.Member;
import com.likelionking.sbbstudy.domain.member.exception.MemberNotFoundExceoption;
import com.likelionking.sbbstudy.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public Member create(KaKaoUserInto kaKaoUserInto){
        String password = kaKaoUserInto.getEmail()+kaKaoUserInto.getNickname();
        Member member = Member.builder()
                .nickname(kaKaoUserInto.getNickname())
                .email(kaKaoUserInto.getEmail())
                .password(passwordEncoder.encode(password))
                .build();
        return memberRepository.save(member);
    }

    public MemberDto find(Long id){
        //Todo
        // 예외처리
        Member member = memberRepository.findById(id).orElseThrow();
        return MemberDto.fromEntity(member);

    }

    /**
     * nickname은 중복이 가능
     */
    public Member find(String email){
        Member member = memberRepository.findByEmail(email).orElseThrow(() ->{
            throw new MemberNotFoundExceoption("Member not Found!!");
        });
        return member;
    }
}
