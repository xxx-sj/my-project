package com.demo.myproject.domain.comment.service;

import com.demo.myproject.domain.comment.domain.Comment;
import com.demo.myproject.domain.posts.domain.Posts;
import com.demo.myproject.domain.comment.dto.CommentResponseDto;
import com.demo.myproject.domain.comment.dto.CommentSaveRequestDto;
import com.demo.myproject.domain.comment.dto.CommentUpdateRequestDto;
import com.demo.myproject.domain.comment.repository.CommentRepository;
import com.demo.myproject.domain.posts.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostsRepository postsRepository;

    //TODO parameter 필요
    public List<CommentResponseDto> find() {
        return commentRepository.findAll().stream()
                .map((comment) -> new CommentResponseDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(Long postsId, CommentSaveRequestDto requestDto) {
        Posts posts = postsRepository.findById(postsId).orElseThrow(
                () -> new IllegalArgumentException("posts 가 존재하지 않습니다. =>" + postsId));

        Comment comment = new Comment(requestDto.getContent()).createComment(posts);

        return commentRepository.save(comment).getId();
    }

    @Transactional
    public Long update(Long id, CommentUpdateRequestDto requestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("일치하는 Comment 가 없습니다. =>" + id));

        comment.update(requestDto.getContent());

        return comment.getId();
    }


    @Transactional
    public void delete(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("일치하는 Comment 가 없습니다. => " + id));

        commentRepository.delete(comment);
    }
}
