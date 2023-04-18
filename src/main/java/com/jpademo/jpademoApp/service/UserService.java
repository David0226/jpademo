package com.jpademo.jpademoApp.service;

import com.jpademo.jpademoApp.entity.UserEntity;
import com.jpademo.jpademoApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserEntity join(String userid, String password){
        userRepository.findById(userid).ifPresent(it->{

        });

        UserEntity userEntity = userRepository.save(UserEntity.of(userid, password));
        return userEntity;
    }


}