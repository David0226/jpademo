package com.jpademo.jpademoApp.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
// record 란?
// DTO를 구현하기 위해서는 getter, setter, equals, hashCode, toString 같은 데이터 처리 혹은 특정 연산을 수행하기 위해 오버라이드된 메소드를 반복해서 작성하게 됩니다.

public record UserDto(
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy,
        Long userId,
        String userPassword,
        String email,
        String nickname
) {
    public static UserDto of(Long userId, String userPassword, String email, String nickname){
        return new UserDto()
    }
}
