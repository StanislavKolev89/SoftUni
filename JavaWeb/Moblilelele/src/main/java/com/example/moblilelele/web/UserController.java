package com.example.moblilelele.web;

import com.example.moblilelele.model.dto.LoginDto;
import com.example.moblilelele.service.UserService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/login")
    public String loginPage() {
        return "auth-login";
    }

    @PostMapping("users/login")
    public String login(LoginDto loginDto) {
        userService.userLogin(loginDto);
        return "redirect:/";
    }

    @GetMapping("users/logout")
    public String logout() {
        userService.userLogout();
        return "redirect:/";
    }


}
