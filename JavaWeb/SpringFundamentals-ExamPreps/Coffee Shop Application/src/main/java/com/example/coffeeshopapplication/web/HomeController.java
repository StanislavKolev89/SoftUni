package com.example.coffeeshopapplication.web;

import com.example.coffeeshopapplication.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final OrderService orderService;
    private final UserService userService;

    public HomeController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("allOrders", orderService.getAllOrders());
        model.addAttribute("empOrders", userService.getOrdersByUser());
        model.addAttribute("timeNeeded",orderService.findNeededTime());
        return "home";
    }
}
