package com.demo.myproject.domain.comment.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentSaveRequestDto {
    private String content;


    @Builder
    public CommentSaveRequestDto(String content) {
        this.content = content;
    }

}
