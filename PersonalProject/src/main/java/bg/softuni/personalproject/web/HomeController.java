package bg.softuni.personalproject.web;

import bg.softuni.personalproject.service.CategoryService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.stream.Collectors;

@EnableWebMvc
@Controller
public class HomeController {

    private final CategoryService categoryService;

    public HomeController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String testPage(Model model){
        model.addAttribute("firstCategoryItem",categoryService.getAllCategories().get(0));
        model.addAttribute("allOtherItems",categoryService.getAllCategories().stream().skip(1).collect(Collectors.toList()));

        return "index";
    }
}
