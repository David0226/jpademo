package com.jpademo.jpademoApp.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;



@Getter
@Setter
@Entity
@Table
public class User {
    @Id
    private String user_id;
    @Column(name = "user_password")
    private String password;
    @Column(length = 50, name = "user_name")
    private String username;
    @Column(length = 30, name = "phone_no")
    private long phoneno;
    @Column(name = "phone_no")
    private boolean admin_yn;
    @CreatedDate
    @Column(name = "created_dt")
    private LocalDateTime created_dt;
}