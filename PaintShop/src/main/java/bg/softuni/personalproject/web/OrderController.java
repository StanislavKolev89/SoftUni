package bg.softuni.personalproject.web;


import bg.softuni.personalproject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class OrderController {

    private final OrderService orderService;

}

