package com.example.LionKingJPA.domain.comment.repository;

import com.example.LionKingJPA.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
