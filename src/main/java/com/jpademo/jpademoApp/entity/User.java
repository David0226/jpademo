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
public class User extends BaseFields {
    @Id
    @Column(length = 50)
    private Long userId;

    @Setter @Column(nullable = false) private String userPassword;

    @Setter @Column(nullable = false, unique = true, length = 45) private String email;

    @Setter @Column(length = 50) private String nickname;

    protected User(){};




}