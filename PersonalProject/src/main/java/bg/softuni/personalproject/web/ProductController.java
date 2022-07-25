package bg.softuni.personalproject.web;

import bg.softuni.personalproject.model.dto.QuantityHolderDTO;
import bg.softuni.personalproject.service.CategoryService;
import bg.softuni.personalproject.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;


    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/products/{category}")
    public String oneCategoryPage(@PathVariable String category, Model model){

        model.addAttribute("chosenCategoryProducts",productService.getFilteredProducts(category));
        model.addAttribute("categoryName",category);
        return "one-category-products";
    }

    @GetMapping("/products/all")
    public String productsPage( Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("allCategories", categoryService.getAllCategories());
        return "products";
    }


    @GetMapping("/products/all/{id}")
    public String productDetails(@PathVariable Long id,Model model) {
        model.addAttribute("productViewModel",productService.findProductById(id));
        return "product-details";
    }





    @ModelAttribute
    public QuantityHolderDTO quantityHolderDTO(){
        return new QuantityHolderDTO();
    }


    @GetMapping("/users/products/forSale")
    private String secondHandProducts(){
        return "second-hand-products";
    }

}
