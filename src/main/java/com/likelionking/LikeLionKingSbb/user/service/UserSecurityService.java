package com.likelionking.LikeLionKingSbb.user.service;

import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import com.likelionking.LikeLionKingSbb.user.domain.UserRole;
import com.likelionking.LikeLionKingSbb.user.repository.UserRepository;
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

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {
    private final UserRepository userRepository;

    // 사용자 명으로 user
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SiteUser siteUser = userRepository.findByUsername(username).orElseThrow(() -> {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        });

        List<GrantedAuthority> authorities = new ArrayList<>();
        if (username.contains("admin")) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }

        // spring security User 객체 생성하여 리턴
        // spring security는 내부적으로 User객체의 비번과 로그인할 때 입력받은 비밀번호가 일치하는지 검사
        return new User(siteUser.getUsername(), siteUser.getPassword(), authorities);
    }
}
