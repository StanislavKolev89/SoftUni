package bg.softuni.personalproject.web;

import bg.softuni.personalproject.model.entity.dto.UserLoginDTO;
import bg.softuni.personalproject.model.entity.dto.UserRegisterDTO;
import bg.softuni.personalproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@EnableWebMvc
@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("badCredentials", true);
        return "login";
    }

    @PostMapping("/login")

    public String loginConfirm(@Valid UserLoginDTO userLoginDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO", bindingResult);
            return "redirect:login";
        }
        System.out.println();
        if (userService.findByEmailAndPassword(userLoginDTO.getEmail(), userLoginDTO.getPassword())) {
            redirectAttributes.addFlashAttribute("badCredentials", true);
            return "redirect:login";
        }
        userService.loginUser(userLoginDTO);

        return "redirect:/";
    }


    @GetMapping("/register")
    public String registerPage(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() ||!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);

            return "redirect:register";
        }



        userService.registerUser(userRegisterDTO);
        return "redirect:login";
    }

    @ModelAttribute
    public UserLoginDTO userLoginDto() {
        return new UserLoginDTO();
    }

    @ModelAttribute
    public UserRegisterDTO userRegisterDTO() {
        return new UserRegisterDTO();
    }

}

