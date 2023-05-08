package com.jpademo.jpademoApp.entity;

import com.jpademo.jpademoApp.entity.BaseFields;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "article_comment")
public class ArticleComment extends BaseFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String parentCommentId;
    @Setter
    @JoinColumn(name = "id")
    @ManyToOne(optional = false)
    private Article article;

    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "userid")
    private User user;
}