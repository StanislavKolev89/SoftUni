package com.example.regexam.controller;

import com.example.regexam.model.binding.UserLoginBindingModel;
import com.example.regexam.model.binding.UserRegisterBindingModel;
import com.example.regexam.model.service.LoginUserServiceModel;
import com.example.regexam.model.service.RegisterUserServiceModel;
import com.example.regexam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        if(!model.containsAttribute("badCredentials")) {
            model.addAttribute("badCredentials", false);
        }
        return "login";
    }


    @GetMapping("/logout")
    public String logout(){
        userService.logoutUser();
        return "redirect:/";
    }
    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userLoginBindingModel",userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",bindingResult);
            return "redirect:login";
        }
        if(userService.findByUsernameAndPassword(userLoginBindingModel.getUsername(),userLoginBindingModel.getPassword())){
            redirectAttributes.addFlashAttribute("badCredentials", true);
            return"redirect:login";
        }

        userService.login(modelMapper.map(userLoginBindingModel, LoginUserServiceModel.class));
        return "redirect:/";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel, BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:register";
        }

        userService.registerUser(modelMapper.map(userRegisterBindingModel, RegisterUserServiceModel.class));
        return "redirect:login";
    }



    @ModelAttribute("userLoginBindingModel")
    public UserLoginBindingModel userLoginBindingModel(){
        return new UserLoginBindingModel();
    }

    @ModelAttribute("userRegisterBindingModel")
    public UserRegisterBindingModel userRegisterBindingModel(){
        return new UserRegisterBindingModel();
    }
}
