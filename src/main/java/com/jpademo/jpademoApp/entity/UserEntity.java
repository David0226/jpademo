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
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, name = "user_name")
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(length = 30, name = "phone_no")
    private long phoneno;

    @Column(name = "admin_yn")
    private boolean adminyn;

    @CreatedDate
    @Column(name = "created_dt")
    private LocalDateTime createddt;

    public static UserEntity of(String email, String password) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setPassword(password);
        return userEntity;
    }
}