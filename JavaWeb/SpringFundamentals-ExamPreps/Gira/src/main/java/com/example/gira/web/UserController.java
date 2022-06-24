package com.example.gira.web;

import com.example.gira.model.Binding.LoginUserBindingModel;
import com.example.gira.model.Binding.RegisterUserBindingModel;
import com.example.gira.model.service.LoginUserService;
import com.example.gira.model.service.RegisterUserService;
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
    public String loginPage(Model model) {
        if (!model.containsAttribute("notExisting")) {
            model.addAttribute("notExisting", false);
        }
        return "login";
    }

    @GetMapping("/register")
    public String regPage() {
        return "register";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid LoginUserBindingModel loginUserBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginUserBindingModel", loginUserBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginUserBindingModel", bindingResult);
            return "redirect:login";
        }
        if (userService.isExisting(loginUserBindingModel.getEmail(), loginUserBindingModel.getPassword())) {
            redirectAttributes.addFlashAttribute("notExisting", true);
            return "redirect:login";
        }

        userService.loginUser(modelMapper.map(loginUserBindingModel, LoginUserService.class));
        return "redirect:/home";
    }

    @PostMapping("/register")
    public String regConfirm(@Valid RegisterUserBindingModel registerUserBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !registerUserBindingModel.getPassword().equals(registerUserBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("registerUserBindingModel", registerUserBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerUserBindingModel", bindingResult);
            System.out.println();
            return "redirect:register";
        }
        userService.register(modelMapper.map(registerUserBindingModel, RegisterUserService.class));

        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }

    @ModelAttribute("loginUserBindingModel")
    public LoginUserBindingModel loginUserBindingModel() {
        return new LoginUserBindingModel();
    }

    @ModelAttribute("registerUserBindingModel")
    public RegisterUserBindingModel registerUserBindingModel() {
        return new RegisterUserBindingModel();
    }
}
