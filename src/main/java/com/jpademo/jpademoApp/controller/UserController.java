package com.jpademo.jpademoApp.controller;


import com.jpademo.jpademoApp.entity.User;
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

    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/api/login")
    public void login(){

    }

    public String login(@ModelAttribute("user") User user, Model model, HttpSession session) {
        try {
            Optional<User> loggedUser = userService.login(user.getEmail(), user.getUserPassword());
            if (loggedUser.isPresent()) { // 로그인 성공 시
                session.setAttribute("user", loggedUser.get()); // 세션에 사용자 정보 저장
                return "redirect:/home"; // 홈 페이지로 리다이렉트
            } else { // 로그인 실패 시
                model.addAttribute("error", "이메일 또는 비밀번호가 올바르지 않습니다.");
                return "login"; // 로그인 페이지로 이동하여 에러 메시지 출력
            }
        } catch(RuntimeException e) {
            model.addAttribute("error", "로그인 중 오류가 발생하였습니다.");
            return "login"; // 로그인 페이지로 이동하여 에러 메시지 출력
        }
    }

    @GetMapping("/signup")
    public void signup(){

    }
//
//    public String getSignupPage(@ModelAttribute("user") User user, Model model) {
//        if (!model.containsAttribute("user")) { // "user" 객체가 없는 경우에만 추가
//            model.addAttribute("user", new User());
//        }
//        return "signup";
//    }
//    @PostMapping("/api/signup")
//    public String signup(@ModelAttribute("user") User user, Model model) {
//        // 회원가입 처리 로직
//        // (예시로는 UserRepository를 사용하여 사용자 정보를 저장하는 로직을 가정)
//        userService.signUp(user);
//        model.addAttribute("message", "회원가입이 완료되었습니다.");
//        return "login";
//    }
}
