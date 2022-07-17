package bg.softuni.personalproject.web;

import bg.softuni.personalproject.model.entity.dto.QuantityHolderDTO;
import bg.softuni.personalproject.service.ProductService;
import bg.softuni.personalproject.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    private final ProductService productService;

    public ShoppingCartController(ShoppingCartService shoppingCartService, ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    @PostMapping("/products/addToCart/{id}")
    public String cartItemAdd(@PathVariable Long id, QuantityHolderDTO quantityHolderDTO) {;
        shoppingCartService.addToCart(id, quantityHolderDTO);
        return "redirect:/products/all";
    }

    @GetMapping("/shoppingCart/details")
    public String orderDetails(Model model) {
//        if (shoppingCartService.isEmpty()) {
//            return "redirect:/";
//        }
        model.addAttribute("cartItems", shoppingCartService.getAllProducts());
        model.addAttribute("totalPrice", shoppingCartService.findTotalSum());

        return "cart-details";
    }

    @GetMapping("/shoppingCart/finishOrder")
    public String finishOrders() {
        shoppingCartService.finishOrder();
        System.out.println();

        return "redirect:/";
    }

    @GetMapping("/shoppingCart/removeProduct/{id}")
    public String removeProductFromCart(@PathVariable("id") Long productId) {
        shoppingCartService.removeProduct(productId);
        return "redirect:/shoppingCart/details";
    }


}
