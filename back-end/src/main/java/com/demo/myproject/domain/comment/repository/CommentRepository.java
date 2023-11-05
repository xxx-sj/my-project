package com.demo.myproject.domain.comment.repository;

import com.demo.myproject.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
