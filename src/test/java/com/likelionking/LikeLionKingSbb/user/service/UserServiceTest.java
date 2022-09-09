package com.likelionking.LikeLionKingSbb.user.service;

import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import com.likelionking.LikeLionKingSbb.user.domain.UserCreateForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void create() {
        UserCreateForm userCreateForm = UserCreateForm.builder()
                .username("user2")
                .password1("password2")
                .password2("password2")
                .email("user2@test.com")
                .build();

        long id = userService.create(userCreateForm);
        SiteUser siteUser = userService.findById(id);

        assertThat(siteUser.getUsername()).isEqualTo("user2");
//        assertThat(siteUser.getPassword()).isEqualTo("password2");
        assertThat(siteUser.getEmail()).isEqualTo("user2@test.com");
    }
}