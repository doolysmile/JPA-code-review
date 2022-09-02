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
public class SiteUser extends BaseEntity {
    @Column(unique = true, length = 50)
    private String email;

    @Column(length = 200)
    private String password;

    @Column(length = 30)
    private String name;

    @Embedded
    @Column(nullable = false)
    private Address address;

    protected SiteUser() {

    }
    public void changePassword(String password){
        this.password = password;
    }
}
