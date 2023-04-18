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
    private String userid;
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

    public static UserEntity of(String userid, String password) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserid(userid);
        userEntity.setPassword(password);
        return userEntity;
    }
}