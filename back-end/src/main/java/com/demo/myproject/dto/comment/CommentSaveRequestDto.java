package com.demo.myproject.dto.comment;

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
