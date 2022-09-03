package com.likelionking.LikeLionKingSbb.user.domain;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("ADMIN_ROLE"),
    USER("USER_ROLE");

    private String value;

    UserRole(String value) {
        this.value = value;
    }
}
