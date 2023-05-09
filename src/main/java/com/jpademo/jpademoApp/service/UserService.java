package com.jpademo.jpademoApp.service;

import com.jpademo.jpademoApp.entity.User;
import com.jpademo.jpademoApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 회원 찾기
    public Optional<User> getUserId(String email){
        return userRepository.findByEmail(email);
    }

    // 회원 가입
    public User signUp(User user){
        User save = userRepository.save(user);

        return userRepository.save(user);
    }

    // 로그인
    public User login(String email, String password){
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        if (user.isPresent()) {
            // 로그인 성공 시 처리
            return user;
        } else {
            // 로그인 실패 시 처리 (예외 처리)
            throw new RuntimeException("로그인 실패: 유저 정보를 찾을 수 없습니다."); // 예외 처리 예시 (원하는 예외 타입 및 메시지로 변경 가능)
        }
    }
}
