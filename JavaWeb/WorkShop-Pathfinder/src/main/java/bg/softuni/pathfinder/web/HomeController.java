package bg.softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/about")
    public String showIndex(){
        return "about";
    }

    @GetMapping("/login")
        public String showLoginPage(){
            return "login";
        }

        @GetMapping("/register")
    public String showRegisterPage(){
        return "register";
        }

}
