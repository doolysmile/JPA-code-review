package com.likelionking.LikeLionKingSbb.comment.service;

import com.likelionking.LikeLionKingSbb.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
}
