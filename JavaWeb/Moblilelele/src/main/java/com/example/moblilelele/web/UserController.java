package com.example.moblilelele.web;

import com.example.moblilelele.model.dto.LoginDto;

import com.example.moblilelele.service.UserService;
import org.springframework.stereotype.Controller;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {


    @ModelAttribute("userModel")
    public LoginDto initUserModel() {
        return new LoginDto();
    }


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/login")
    public String loginPage() {
        return "auth-login";
    }

    @PostMapping("users/login")
    public String login(@Valid LoginDto loginDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userModel",loginDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/login";
        }

        userService.userLogin(loginDto);
        return "redirect:/";
    }


    @GetMapping("users/logout")
    public String logout() {
        userService.userLogout();
        return "redirect:/";
    }


}
