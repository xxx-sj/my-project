package com.demo.myproject.service.posts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @PersistenceContext
    EntityManager em;

    
    @Test
    @DisplayName("등록일 테스트")
    public void save() {

    }

}