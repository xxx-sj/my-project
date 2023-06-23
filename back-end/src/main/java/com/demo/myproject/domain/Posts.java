package com.demo.myproject.domain;

import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Posts {

    @Id
    @GeneratedValue
    @Column(name = "POSTS_ID")
    private Long id;

    @Column
    private String title;
    @Column
    private String content;

    @OneToMany(mappedBy = "posts")
    private List<Comment> commentList = new ArrayList<>();
}
