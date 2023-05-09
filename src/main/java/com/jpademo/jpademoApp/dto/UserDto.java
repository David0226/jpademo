package com.jpademo.jpademoApp.dto;

import com.jpademo.jpademoApp.entity.User;

import java.time.LocalDateTime;
// record 란?
// DTO를 구현하기 위해서는 getter, setter, equals, hashCode, toString 같은 데이터 처리 혹은 특정 연산을 수행하기 위해 오버라이드된 메소드를 반복해서 작성하게 됩니다.

public record UserDto(
        String userId,
        String userPassword,
        String email,
        String nickname,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    // 해당 dto 객체 생성
    public static UserDto of(String userId, String userPassword, String email, String nickname){
        return new UserDto(userId, userPassword, email, nickname, null,null,null,null);
    }
    public static UserDto of(String userId, String userPassword, String email, String nickname, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy){
        return new UserDto(userId, userPassword, email, nickname, createdAt,createdBy,modifiedAt,modifiedBy);
    }


    // entity -> DTO 객체
    public static UserDto from(User entity){
        return new UserDto(
                entity.getUserId(),
                entity.getUserPassword(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }
    public User toEntity(){
        return User.of(
                userId,
                userPassword,
                email,
                nickname
        );
    }
}
