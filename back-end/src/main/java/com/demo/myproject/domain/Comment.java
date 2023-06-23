package com.demo.myproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "COMMENT_ID")
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSTS_ID")
    private Posts posts;
}
