package com.jpademo.jpademoApp.controller;


import com.jpademo.jpademoApp.entity.UserEntity;
import com.jpademo.jpademoApp.repository.UserRepository;
import com.jpademo.jpademoApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("user", new UserEntity());
        return "login";
    }

    @PostMapping("/api/login")
    public String login(@ModelAttribute UserEntity user, Model model, HttpSession session) {
        try {
            Optional<UserEntity> loggedUser = userService.login(user.getEmail(), user.getPassword());
            session.setAttribute("user", loggedUser);
            return "redirect:/";
        } catch(RuntimeException  e) {
            model.addAttribute("error", "이메일 또는 비밀번호가 올바르지 않습니다.");
            return "login";
        }
    }

    @GetMapping("/signup")
    public String getSignupPage(Model model) {
        model.addAttribute("user", new UserEntity());
        return "signup";
    }

    @PostMapping("/api/signup")
    public String signup(@ModelAttribute("user") UserEntity user, Model model) {
        // 회원가입 처리 로직
        // (예시로는 UserRepository를 사용하여 사용자 정보를 저장하는 로직을 가정)
        userService.signUp(user);
        model.addAttribute("message", "회원가입이 완료되었습니다.");
        return "login";
    }
}
