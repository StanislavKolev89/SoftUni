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




    @GetMapping("orders/all")
    public String allOrders() {
        return "all-orders";
    }






}

