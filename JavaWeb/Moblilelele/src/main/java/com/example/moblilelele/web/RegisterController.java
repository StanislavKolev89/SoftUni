package com.example.moblilelele.web;

import com.example.moblilelele.model.dto.RegisterDto;
import com.example.moblilelele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class RegisterController {

    private UserService userService;


    @ModelAttribute("userModel")
    public RegisterDto initUserModel() {
        return new RegisterDto();
    }


    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String userRegister(){
        return"auth-register";
    }

    @PostMapping("/register")
    public String userRegister(@Valid RegisterDto registerModel, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userModel",registerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/register";
        }
        userService.userRegister(registerModel);
        return"redirect:/";
    }
}
