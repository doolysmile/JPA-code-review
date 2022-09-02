package com.likelionking.LikeLionKingSbb.user.repository;

import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
}
