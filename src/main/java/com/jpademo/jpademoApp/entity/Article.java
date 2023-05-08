package com.jpademo.jpademoApp.entity;

import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Article extends BaseFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter @Column(nullable = false) private String title; // 제목
    @Setter @Column(nullable = false, length = 10000) private String content; // 본문

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public Article (){}

    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }

}
