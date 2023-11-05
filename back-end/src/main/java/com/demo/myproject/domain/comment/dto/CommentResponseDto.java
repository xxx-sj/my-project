package com.demo.myproject.domain.comment.dto;

import com.demo.myproject.domain.comment.domain.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {

    private Long id;
    private String content;
    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
    }
}
