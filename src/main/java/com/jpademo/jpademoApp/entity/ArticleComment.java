package com.jpademo.jpademoApp.entity;

import com.jpademo.jpademoApp.entity.BaseFields;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "article_comment")
public class ArticleComment extends BaseFields {
}