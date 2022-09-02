package com.example.demo.auth.service;

import com.example.demo.domain.user.entity.SiteUser;
import com.example.demo.domain.user.entity.SiteUserRole;
import com.example.demo.domain.user.repository.SiteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LocalSecurityService implements UserDetailsService {
    private  final SiteUserRepository siteUserRepository;

    /**
     * 사용자 명으로 비밀번호를 조회하여 리턴하는 메서드
     * @param email the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        SiteUser siteUser = siteUserRepository.findByEmail(email)
                .orElseThrow(() ->  new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        List<GrantedAuthority> authorities = new ArrayList<>();
        // role을 생성하지 않았기 떄문에 아직 쓸모 없다.
        // TODO 권한 부여
        if ("admin".equals(email)) {
            authorities.add(new SimpleGrantedAuthority(SiteUserRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(SiteUserRole.USER.getValue()));
        }


        // user객체의 비밀번호가 화면으로부터 입력받은 비밀번호와 일치하는지 검사.
        return new User(siteUser.getEmail(), siteUser.getPassword(), authorities);
    }
}
