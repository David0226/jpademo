package com.jpademo.jpademoApp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table()
@Data
public class User extends BaseFields {
    @Id
    @Column(length = 50)
    private String userId;

    @Setter @Column(nullable = false) private String userPassword;

    @Setter @Column(nullable = false, unique = true, length = 45) private String email;

    @Setter @Column(length = 50) private String nickname;

    // Parameter를 받지 않는 default 생성자
    public User(){}

    public User of(String userId, String userPassword, String email, String nickname){

    }
    // User class를 생성하는 of 이름의 정적 메소드
    public static User of(Long userId, String userPassword, String email, String nickname) {
        return new User(userId, userPassword, email, nickname);

    }
}