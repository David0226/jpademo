package com.jpademo.jpademoApp.entity;

import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(nullable = false) private String title;
    @Setter private String comment;
    private String hashtag;

    private LocalDateTime CreateAt;
}
