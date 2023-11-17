package com.demo.myproject.service.posts;

import com.demo.myproject.domain.Posts;
import com.demo.myproject.dto.posts.PostsResponseDto;
import com.demo.myproject.dto.posts.PostsSaveRequestDto;
import com.demo.myproject.dto.posts.PostsUpdateRequestDto;
import com.demo.myproject.repository.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;


    public List<PostsResponseDto> find() {
        return postsRepository.findAll().stream()
                .map(posts -> new PostsResponseDto(posts))
                .collect(Collectors.toList());
    }


    public PostsResponseDto findOne(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다. =" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다 = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다. = " + id));

        postsRepository.delete(posts);
    }
}
