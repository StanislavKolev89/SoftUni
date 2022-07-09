package bg.softuni.personalproject.web;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Controller
public class HomeController {

    @GetMapping("/")
    public String testPage(){
        return "index";
    }
}
