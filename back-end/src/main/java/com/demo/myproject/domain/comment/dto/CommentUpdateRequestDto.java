package com.demo.myproject.domain.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentUpdateRequestDto {

    private String content;

    @Builder
    public CommentUpdateRequestDto(String content) {
        this.content = content;
    }

}
