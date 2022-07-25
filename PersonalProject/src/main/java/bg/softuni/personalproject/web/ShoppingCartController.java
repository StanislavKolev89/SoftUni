package bg.softuni.personalproject.web;

import bg.softuni.personalproject.model.dto.QuantityHolderDTO;
import bg.softuni.personalproject.service.ProductService;
import bg.softuni.personalproject.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;


@Controller
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    private final ProductService productService;

    public ShoppingCartController(ShoppingCartService shoppingCartService, ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    @PostMapping("/products/addToCart/{id}")
    public String cartItemAdd(@PathVariable Long id, QuantityHolderDTO quantityHolderDTO) {
        shoppingCartService.addToCart(id, quantityHolderDTO);
        return "redirect:/products/all";
    }

    @GetMapping("/products/fromCart/{id}/{quantity}")
    public String productDetails(@PathVariable Long id, @PathVariable int quantity, Model model, QuantityHolderDTO quantityHolderDTO) {
        model.addAttribute("productViewModel", productService.findProductById(id));
        quantityHolderDTO.setQuantity(quantity);
        return "product-details";
    }

    @GetMapping("/shoppingCart/details")
    public String orderDetails(Model model) {
        model.addAttribute("cartItems", shoppingCartService.getAllProducts());
        model.addAttribute("totalPrice", shoppingCartService.findTotalSum());
        model.addAttribute("service",shoppingCartService);

        return "cart-details";
    }

    @GetMapping("/shoppingCart/finishOrder")
    public String finishOrders(Principal principal) {
        shoppingCartService.finishOrder(principal.getName());
        System.out.println();

        return "redirect:/";
    }

    @GetMapping("/shoppingCart/removeProduct/{id}")
    public String removeProductFromCart(@PathVariable("id") Long productId) {
        shoppingCartService.removeProduct(productId);
        return "redirect:/shoppingCart/details";
    }


}
