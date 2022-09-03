package com.study.blog.domain.member.service;

import com.study.blog.common.exception.MemberNotFoundException;
import com.study.blog.domain.member.domain.Member;
import com.study.blog.domain.member.domain.dto.MemberDto;
import com.study.blog.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void create(MemberDto memberDto) {
        Member member = memberDto.toEntity();
        memberRepository.save(member);
    }

    public MemberDto findById(long id){
        Optional<Member> found = memberRepository.findById(id);

        if(found.isEmpty()){
            throw new MemberNotFoundException("해당 Id의 멤버는 존재하지 않습니다.");
        }

        MemberDto memberDto = MemberDto.builder()
                .password(found.get().getPassword())
                .memberName(found.get().getMemberName())
                .email(found.get().getEmail())
                .build();

        return memberDto;
    }

    public long memberCount(){
        return memberRepository.count();
    }
}
