package bg.softuni.personalproject.web;

import bg.softuni.personalproject.model.entity.dto.CartItemDto;
import bg.softuni.personalproject.model.entity.model.OrderProductEntity;
import bg.softuni.personalproject.model.entity.model.ProductEntity;
import bg.softuni.personalproject.service.CategoryService;
import bg.softuni.personalproject.service.OrderService;
import bg.softuni.personalproject.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;


    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
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
        System.out.println();
        return "product-details";
    }

    @PostMapping("/products/addToCart/{id}")
        public String cartItemAdd(@PathVariable Long id, CartItemDto cartItemDto, HttpSession httpSession){

            if(httpSession.getAttribute("cartItems")==null) {
                Map<ProductEntity, Integer> cartItems = new HashMap<>();
                cartItems.put(productService.findProductById(id), cartItemDto.getQuantity());
                httpSession.setAttribute("cartItems", cartItems);
            }else {
                Map<ProductEntity, Integer> cartItems = (Map<ProductEntity, Integer>) httpSession.getAttribute("cartItems");
                cartItems.put(productService.findProductById(id), cartItemDto.getQuantity());
            }
            return "redirect:/products/all";
        }


    @ModelAttribute
    public CartItemDto cartItemDto(){
        return new CartItemDto();
    }

}
