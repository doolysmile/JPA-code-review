package com.study.blog.domain.member.service;

import com.study.blog.common.exception.EmailDuplicatedException;
import com.study.blog.common.exception.MemberNameDuplicatedException;
import com.study.blog.common.exception.MemberNotFoundException;
import com.study.blog.domain.member.domain.Member;
import com.study.blog.domain.member.domain.dto.MemberDto;
import com.study.blog.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    public void create(MemberDto memberDto) {
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        Member member = memberDto.toEntity();

        try {
            memberRepository.save(member);
        }catch (DataIntegrityViolationException e){
            if(memberRepository.existsByMemberName(memberDto.getMemberName())){
                throw new MemberNameDuplicatedException("이미 사용중인 Membername입니다.");
            }
            else{
                throw new EmailDuplicatedException("이미 사용중인 Email 입니다.");
            }
        }
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

    public MemberDto findByMemberName(String memberName){
        Optional<Member> found = memberRepository.findByMemberName(memberName);

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
