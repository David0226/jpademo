package com.jpademo.jpademoApp.repository;

import com.jpademo.jpademoApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}