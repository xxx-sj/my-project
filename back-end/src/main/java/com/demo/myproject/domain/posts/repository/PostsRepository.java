package com.demo.myproject.domain.posts.repository;

import com.demo.myproject.domain.posts.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
