package com.likelionking.LikeLionKingSbb.comment.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentForm {
    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;

    public static CommentDto toDto(CommentForm commentForm) {
        return CommentDto.builder()
                .content(commentForm.getContent())
                .build();
    }
}
