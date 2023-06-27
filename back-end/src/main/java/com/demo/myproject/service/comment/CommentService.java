package com.demo.myproject.service.comment;

import com.demo.myproject.domain.Comment;
import com.demo.myproject.dto.comment.CommentResponseDto;
import com.demo.myproject.dto.comment.CommentUpdateRequestDto;
import com.demo.myproject.repository.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;
    //TODO parameter 필요
    public List<CommentResponseDto> find() {
        return repository.findAll().stream()
                .map((comment) -> new CommentResponseDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public Long update(Long id, CommentUpdateRequestDto requestDto) {
        Comment comment = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("일치하는 Comment 가 없습니다. =>" + id));

        comment.update(requestDto.getContent());

        return comment.getId();
    }


    @Transactional
    public void delete(Long id) {
        Comment comment = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("일치하는 Comment 가 없습니다. => " + id));

        repository.delete(comment);
    }
}
