package com.jpademo.jpademoApp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table()
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(length = 30)
    private long phoneno;

    @Column(name = "admin_yn")
    private boolean adminyn;

    @CreatedDate
    @Column
    private LocalDateTime createddt;

    public static User of(String email, String password) {
        User userEntity = new User();
        userEntity.setEmail(email);
        userEntity.setPassword(password);
        return userEntity;
    }
}