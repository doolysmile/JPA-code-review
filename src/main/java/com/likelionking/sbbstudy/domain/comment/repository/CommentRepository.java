package com.likelionking.sbbstudy.domain.comment.repository;

import com.likelionking.sbbstudy.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
