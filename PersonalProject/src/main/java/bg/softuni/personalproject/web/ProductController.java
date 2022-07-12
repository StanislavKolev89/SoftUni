package bg.softuni.personalproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/products/all")
    public String productsPage(){
        return "products";
    }
}
