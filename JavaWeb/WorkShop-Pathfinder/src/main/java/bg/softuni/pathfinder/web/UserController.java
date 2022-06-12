package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.dto.UserLoginDto;
import bg.softuni.pathfinder.model.dto.UserRegisterDto;
import bg.softuni.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    @ModelAttribute("userRegisterDto")
    public UserRegisterDto getRegisterUser() {

        return new UserRegisterDto();
    }

    @ModelAttribute("userLoginDto")
    public UserLoginDto getLoginUser() {

        return new UserLoginDto();
    }

    @GetMapping("/logout")
    public String logout() {

        userService.logoutUser();
        return "index";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid UserRegisterDto userRegisterDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        System.out.println();
        if (bindingResult.hasErrors() ||
                userService.usernameIsExisting(userRegisterDto) || !userRegisterDto.passwordsAreEqual()) {
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto).
                    addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDto", bindingResult);
            return "redirect:register";
        }
        userService.registerNewUser(userRegisterDto);
        return "redirect:login";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String logUser(@Valid UserLoginDto userLoginDto, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userService.userExists(userLoginDto.getUsername(), userLoginDto.getPassword())) {
            redirectAttributes.addFlashAttribute("userLoginDto", userLoginDto).
                    addFlashAttribute("org.springframework.validation.BindingResult.userLoginDto", bindingResult);
            return "redirect:login";
        }
        userService.loginUser(userLoginDto.getUsername(),userLoginDto.getPassword());
        return "index";
    }

    @GetMapping("/profile/{id}")
    private String profile(@PathVariable Long id, Model model){

        model
                .addAttribute("user", userService.findById(id));

        return "profile";
    }


}
