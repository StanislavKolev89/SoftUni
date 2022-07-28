package bg.softuni.personalproject.web;

import bg.softuni.personalproject.model.view.CategoryViewModel;
import bg.softuni.personalproject.model.view.UsedProductViewModel;
import bg.softuni.personalproject.service.CategoryService;
import bg.softuni.personalproject.service.UsedProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
@RequestMapping("/products")
public class UsedProductController {

    private final UsedProductService usedProductService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @GetMapping("/users/forSale")
    private String secondHandProducts(Model model) {
        model.addAttribute("usedProducts", usedProductService.getAllProducts()
                .stream().map(usedProductDTO -> modelMapper.map(usedProductDTO, UsedProductViewModel.class))
                .collect(Collectors.toList()));
        model.addAttribute("allCategories", categoryService.getAllCategories()
                .stream().map(categoryDTO -> modelMapper.map(categoryDTO, CategoryViewModel.class))
                .collect(Collectors.toList()));

        return "second-hand-products";
    }
}
