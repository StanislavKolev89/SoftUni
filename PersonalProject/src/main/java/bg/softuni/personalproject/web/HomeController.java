package bg.softuni.personalproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @CrossOrigin
    @GetMapping("/")
    public String testPage(){
        return "index";
    }
}
