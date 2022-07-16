package bg.softuni.personalproject.web;

import bg.softuni.personalproject.model.entity.model.ProductEntity;
import bg.softuni.personalproject.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/details")
    public String orderDetails(HttpSession httpSession, Model model) {

        if (httpSession.getAttribute("cartItems") == null) {
            return "redirect:/";
        }

        HashMap<ProductEntity, Integer> map = (HashMap<ProductEntity, Integer>) httpSession.getAttribute("cartItems");
        model.addAttribute("totalPrice", countTotalSum(map));

        return "order-details";
    }



    @GetMapping("orders/all")
    public String allOrders() {
        return "all-orders";
    }


    private BigDecimal countTotalSum(HashMap<ProductEntity, Integer> map) {System.out.println();
       List<BigDecimal> total = new ArrayList<>();
        map.entrySet().stream().forEach(product -> {
           total.add(product.getKey().getPrice().multiply(BigDecimal.valueOf(product.getValue())));
        });

        return total.stream().reduce(BigDecimal.ZERO,BigDecimal::add);

    }


    @GetMapping("orders/finishOrder")
    public String finishOrders(HttpSession httpSession){
        orderService.addOrder((Map<ProductEntity, Integer>) httpSession.getAttribute("cartItems"));
        System.out.println();
        httpSession.removeAttribute("cartItems");
        return "redirect:/";
    }

}

