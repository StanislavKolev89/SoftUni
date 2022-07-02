package com.example.coffeeshopapplication.web;

import com.example.coffeeshopapplication.model.entity.UserEntity;
import com.example.coffeeshopapplication.repository.UserRepository;
import com.example.coffeeshopapplication.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        System.out.println();
        return "home";
    }

    @GetMapping("/hello")
    public ResponseEntity<UserEntity> hello() {
        return ResponseEntity.ok(UserEntity.builder()
                .email("test")
                .build());
    }


    @PostMapping("/hello")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void helloPost(@RequestBody UserEntity userEntity) {
//        System.out.println(1/0);
        throw new IllegalArgumentException("Vui");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> error(Exception exception) {
        return ResponseEntity.status(400).body(exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> badRequest(Exception exception) {
        return ResponseEntity.status(400).body(exception.getMessage());
    }
}
