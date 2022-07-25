package bg.softuni.personalproject.web;

import bg.softuni.personalproject.model.dto.UserLoginDTO;
import bg.softuni.personalproject.model.dto.UserRegisterDTO;
import bg.softuni.personalproject.service.UserService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {

        return "login";
    }

    @PostMapping("/login-error")
    public String onFailedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String userName,
            RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, userName);
        redirectAttributes.addFlashAttribute("bad_credentials",
                true);

        return "redirect:/users/login";
    }


    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        System.out.println();
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);

            return "redirect:register";
        }

        userService.registerAndLoginUser(userRegisterDTO);
        return "redirect:/";
    }

//    @ModelAttribute
//    public UserLoginDTO userLoginDto() {
//        return new UserLoginDTO();
//    }

    @ModelAttribute
    public UserRegisterDTO userRegisterDTO() {
        return new UserRegisterDTO();
    }

}

