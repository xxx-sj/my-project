package com.demo.myproject.repository.posts;

import com.demo.myproject.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
