package com.demo.myproject.domain.comment.controller;

import com.demo.myproject.domain.comment.dto.CommentSaveRequestDto;
import com.demo.myproject.domain.comment.dto.CommentUpdateRequestDto;
import com.demo.myproject.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //TODO parameter 필요
//    @GetMapping("")
//    public List<CommentResponseDto> find() {
//        return commentService.find();
//    }

//    @GetMapping("/{id}")
//    public CommentResponseDto findOne(@PathVariable Long id) {
//        return commentService.findOne(id);
//    }

    //Parameter 필요
    @PostMapping("")
    public Long save(@PathVariable(name = "postsId") Long postsId, @RequestBody CommentSaveRequestDto requestDto) {
        return commentService.save(postsId, requestDto);
    }

    @PutMapping("{id}")
    public Long update(@PathVariable Long id, @RequestBody CommentUpdateRequestDto requestDto) {
        return commentService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        commentService.delete(id);

        return id;
    }

}
