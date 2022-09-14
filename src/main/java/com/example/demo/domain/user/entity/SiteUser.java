package com.example.demo.domain.user.entity;

import com.example.demo.global.common.embedded.Address;
import com.example.demo.global.common.entity.BaseEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

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

    // TODO role 컴버터와 함께 구현
//    @Enumerated(EnumType.STRING)
//    @Column(columnDefinition = "ROLE_ADMIN")
//    private SiteUserRole role;

    protected SiteUser() {

    }
    public void changePassword(String password){
        this.password = password;
    }
}
