package com.demo.myproject.repository.comment;

import com.demo.myproject.domain.Comment;
import com.demo.myproject.domain.Posts;
import com.demo.myproject.repository.posts.PostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@SpringBootTest
@Transactional
class CommentRepositoryTest {

    @Autowired CommentRepository commentRepository;
    @Autowired PostsRepository postsRepository;
    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("comment save 테스트")
    public void save() {
        Posts posts = new Posts("제목", "내용");
        Posts savedPosts = postsRepository.save(posts);

        Comment comment = Comment.createComment(savedPosts, "댓글 내용");
        Comment savedComment = commentRepository.save(comment);

        em.flush();
        em.clear();

        Posts dbPosts = postsRepository.findById(savedPosts.getId()).get();
        Assertions.assertThat(dbPosts.getCommentList().get(0).getContent()).isEqualTo("댓글 내용");
    }
}