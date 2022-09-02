package com.example.demo.domain.user.entity;

import com.example.demo.global.common.embedded.Address;
import com.example.demo.global.common.entity.BaseEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Getter
@Entity
@SuperBuilder
public class User extends BaseEntity {
    @Column(unique = true)
    private String email;

    private String password;

    private String username;

    @Embedded
    private Address address;

    protected User() {

    }
}
