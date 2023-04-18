package com.jpademo.jpademoApp.service;

import com.jpademo.jpademoApp.entity.User;
import com.jpademo.jpademoApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


}