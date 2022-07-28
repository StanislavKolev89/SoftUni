package bg.softuni.personalproject.web;

import bg.softuni.personalproject.service.CategoryService;
import bg.softuni.personalproject.service.UsedProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/products")
public class UsedProductController {

    private final UsedProductService usedProductService;
    private final CategoryService categoryService;

    @GetMapping("/users/forSale")
    private String secondHandProducts(Model model) {
        model.addAttribute("usedProducts", usedProductService.getAllProducts());
        model.addAttribute("allCategories", categoryService.getAllCategories());

        return "second-hand-products";
    }
}
