package com.demo.myproject.controller;

import com.demo.myproject.dto.comment.CommentResponseDto;
import com.demo.myproject.dto.comment.CommentSaveRequestDto;
import com.demo.myproject.dto.comment.CommentUpdateRequestDto;
import com.demo.myproject.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//    @PostMapping("")
//    public Long save(@RequestBody CommentSaveRequestDto requestDto) {
//        return commentService.save(requestDto);
//    }

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
