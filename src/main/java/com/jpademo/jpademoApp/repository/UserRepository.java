package com.jpademo.jpademoApp.repository;

import com.jpademo.jpademoApp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}