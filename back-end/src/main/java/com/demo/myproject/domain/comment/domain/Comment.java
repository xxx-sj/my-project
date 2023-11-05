package com.demo.myproject.domain.comment.domain;

import com.demo.myproject.global.common.BaseEntity;
import com.demo.myproject.domain.posts.domain.Posts;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "content"})
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "CMT_ID")
    private Long id;

    @Column(name = "CMT_CONTENT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSTS_ID")
    private Posts posts;

    public Comment(String content) {
        this.content = content;
    }
    public void setPosts(Posts posts) {
        this.posts = posts;
        posts.getCommentList().add(this);
    }

    public Comment createComment(Posts posts) {
        this.setPosts(posts);
        return this;
    }

    public void update(String content) {
        this.content = content;
    }
}
