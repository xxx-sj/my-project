package com.demo.myproject.domain;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class Posts {
    @Id
    @Column(name = "BOARD_ID")
    @GeneratedValue
    private Long id;

    @Column
    private String title;
    @Column
    private String content;
}
