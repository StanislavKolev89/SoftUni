package bg.softuni.personalproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @GetMapping("/products/all")
    public String productsPage(){
        return "products";
    }

    @GetMapping("/products/all/1")
    public String productDetails(){
        return "product-details";
    }
}
