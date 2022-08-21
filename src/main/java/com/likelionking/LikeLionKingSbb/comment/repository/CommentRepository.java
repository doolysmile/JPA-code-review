package com.likelionking.LikeLionKingSbb.comment.repository;

import com.likelionking.LikeLionKingSbb.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
