package com.demo.myproject.repository.comment;

import com.demo.myproject.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
