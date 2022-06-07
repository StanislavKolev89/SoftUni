package com.example.moblilelele.web;

import com.example.moblilelele.model.dto.LoginDto;
import com.example.moblilelele.model.dto.RegisterDto;
import com.example.moblilelele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

        @GetMapping("users/login")
        public String loginPage(){
        return "auth-login";
        }

        @GetMapping("users/logout")
        public String logout(){
        userService.userLogout();
        return "redirect:/";
        }

        @GetMapping("users/register")
        public String userRegister(){
        return"auth-register";
        }

}
