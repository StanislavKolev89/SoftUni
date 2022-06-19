package com.example.battleship.web;

import com.example.battleship.entity.binding.UserLoginBindingModel;
import com.example.battleship.entity.binding.UserRegisterBindingModel;
import com.example.battleship.entity.service.UserLoginServiceModel;
import com.example.battleship.entity.service.UserRegisterServiceModel;
import com.example.battleship.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller

public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @ModelAttribute("userLoginBindingModel")
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }

    @ModelAttribute("userRegisterBindingModel")
    public UserRegisterBindingModel registerBindingResult() {

        return new UserRegisterBindingModel();
    }

    @GetMapping("/users/login")
    public String loginPage(Model model) {
        model.addAttribute("notExisting", false);

        return "login";
    }

    @PostMapping("/users/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }

        boolean exists = userService.existsByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());
        if (!exists) {
            redirectAttributes.addFlashAttribute("notExisting", true);
            return "redirect:login";
        }

        userService.loginUser(modelMapper.map(userLoginBindingModel, UserLoginServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("users/register")
    public String registerPage(Model model) {
        model.addAttribute("usernameTaken", false);
        model.addAttribute("emailTaken", false);
        return "register";
    }

    @PostMapping("users/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        System.out.println();
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }

        userService.registerNewUser(modelMapper.map(userRegisterBindingModel, UserRegisterServiceModel.class));
        return "login";
    }

    @GetMapping("users/logout")
    public String logout(){
        userService.logoutUser();
        return "index";
    }
}
