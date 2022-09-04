package com.example.LionKingJPA.domain.user.repository;


import com.example.LionKingJPA.domain.user.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
}