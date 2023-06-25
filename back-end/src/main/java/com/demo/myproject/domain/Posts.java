package com.demo.myproject.domain;

import com.demo.myproject.repository.PostsRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Posts {

    @Id
    @Column(name = "PTS_ID")
    @GeneratedValue
    private Long id;

    @Column(name = "PTS_TITLE")
    private String title;

    @Column(name ="PTS_CONTENT")
    private String content;

    @OneToMany(mappedBy = "posts", fetch = FetchType.LAZY)
    private List<Comment> commentList = new ArrayList<>();

    @Builder
    public Posts(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
