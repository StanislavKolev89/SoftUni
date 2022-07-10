package bg.softuni.personalproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class OrderController {

    @GetMapping("orders/details")
    public String orderDetails(){
        return "order-details";
    }

    @GetMapping("orders/all")
    public String allOrders(){
        return "all-orders";
    }
}

