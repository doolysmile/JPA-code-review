package com.likelionking.sbbstudy.domain.member.service;

import com.likelionking.sbbstudy.domain.member.dto.MemberDto;
import com.likelionking.sbbstudy.domain.member.entity.Member;
import com.likelionking.sbbstudy.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public void create(Member member){
        memberRepository.save(member);
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
    public MemberDto find(String email){
        Member member = memberRepository.findByEmail(email);
        return MemberDto.fromEntity(member);
    }
}
