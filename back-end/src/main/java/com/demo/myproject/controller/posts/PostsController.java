package com.demo.myproject.controller.posts;

import com.demo.myproject.dto.posts.PostsResponseDto;
import com.demo.myproject.dto.posts.PostsSaveRequestDto;
import com.demo.myproject.dto.posts.PostsUpdateRequestDto;
import com.demo.myproject.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostsController {

    private final PostsService postsService;

    //find
    @GetMapping("")
    public List<PostsResponseDto> find() {
        return postsService.find();
    }

    //findOne
    @GetMapping("/{id}")
    public PostsResponseDto findOne(@PathVariable Long id) {

        return postsService.findOne(id);
    }

    //save

    @PostMapping("")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {

        return postsService.save(requestDto);
    }

    //update
    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    //delete
    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);

        return id;
    }

}
