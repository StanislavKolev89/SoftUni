package com.example.coffeeshopapplication.web;

import com.example.coffeeshopapplication.model.binding.LoginPageBindingModel;
import com.example.coffeeshopapplication.model.binding.RegisterPageBindingModel;
import com.example.coffeeshopapplication.model.service.LoginUserServiceModel;
import com.example.coffeeshopapplication.model.service.RegisterUserServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
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

    @GetMapping("/logout")
    private String logoutUser(HttpSession httpSession){
        userService.logoutUser();
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("badCredentials", false);
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid LoginPageBindingModel loginPageBindingModel, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginPageBindingModel", loginPageBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginPageBindingModel", bindingResult);
            return "redirect:login";
        }

        if (userService.findByUsernameAndPassword(loginPageBindingModel.getUsername(), loginPageBindingModel.getPassword())) {
            redirectAttributes.addFlashAttribute("badCredentials", true);
            return"redirect:login";
        }
        userService.loginUser(modelMapper.map(loginPageBindingModel, LoginUserServiceModel.class));

        return "redirect:/";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid RegisterPageBindingModel registerPageBindingModel, BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !registerPageBindingModel.getPassword().equals(registerPageBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("registerPageBindingModel", registerPageBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerPageBindingModel", bindingResult);

            return "redirect:register";
        }

        userService.registerUser(modelMapper.map(registerPageBindingModel, RegisterUserServiceModel.class));
        return "redirect:login";
    }

    @ModelAttribute("loginPageBindingModel")
    public LoginPageBindingModel loginPagaBindingModel() {
        return new LoginPageBindingModel();
    }

    @ModelAttribute("registerPageBindingModel")
    public RegisterPageBindingModel registerPageBindingModel() {
        return new RegisterPageBindingModel();
    }

}
