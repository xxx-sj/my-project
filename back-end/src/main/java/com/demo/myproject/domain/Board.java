package com.demo.myproject.domain;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class Board {
    @Id
    @Column(name = "board_id")
    @GeneratedValue
    private Long id;

    @Column
    private String title;
    @Column
    private String content;
}
