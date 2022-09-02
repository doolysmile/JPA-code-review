package com.likelionking.LikeLionKingSbb.user.repository;

import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void createSampleData() {
        SiteUser user1 = SiteUser.builder()
                .username("user1")
                .password("1234")
                .email("user1@test.com")
                .build();

        userRepository.save(user1);
    }
}