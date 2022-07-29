package bg.softuni.personalproject.web;

import bg.softuni.personalproject.model.dto.QuantityHolderDTO;
import bg.softuni.personalproject.model.view.CategoryViewModel;
import bg.softuni.personalproject.model.view.ProductViewModel;
import bg.softuni.personalproject.service.CategoryService;
import bg.softuni.personalproject.service.ProductService;

import bg.softuni.personalproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ModelMapper modelMapper;


    @GetMapping("/{category}")
    public String oneCategoryPage(@PathVariable String category, Model model){

        model.addAttribute("chosenCategoryProducts",productService.getFilteredProducts(category));
        model.addAttribute("categoryName",category);
        return "one-category-products";
    }

    @GetMapping("/all")
    public String productsPage( Model model) {
        model.addAttribute("products", productService.getAllProducts()
                        .stream().map(productDTO ->modelMapper.map(productDTO, ProductViewModel.class))
                .collect(Collectors.toList()));
        model.addAttribute("allCategories", categoryService.getAllCategories()
                .stream().map(categoryDTO -> modelMapper.map(categoryDTO, CategoryViewModel.class))
                .collect(Collectors.toList()));
        return "products";
    }


    @GetMapping("/all/{id}")
    public String productDetails(@PathVariable Long id, Model model, Principal principal) {
        model.addAttribute("productViewModel",productService.findProductById(id));
        model.addAttribute("active",userService.findByName(principal.getName()).isActive());
        return "product-details";
    }


    @ModelAttribute
    public QuantityHolderDTO quantityHolderDTO(){
        return new QuantityHolderDTO();
    }



}
