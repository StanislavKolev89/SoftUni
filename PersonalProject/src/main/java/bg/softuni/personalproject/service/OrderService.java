package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.model.OrderEntity;
import bg.softuni.personalproject.model.entity.model.ProductEntity;
import bg.softuni.personalproject.model.entity.model.UserEntity;
import bg.softuni.personalproject.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    private final OrderProductService orderProductService;

    public OrderService(OrderRepository orderRepository, OrderProductService orderProductService) {
        this.orderRepository = orderRepository;
        this.orderProductService = orderProductService;
    }

//    ToDO Pass user To The Order and make (nullable=false) User in OrderEntity
    public void createOrder(Map<ProductEntity, Integer> cartItems, UserEntity buyer) {
        OrderEntity order = new OrderEntity().setDate(LocalDateTime.now());
        order.setUser(buyer);
        orderRepository.save(order);
        cartItems.entrySet().stream().forEach(product -> {

            orderProductService.addOrderAndProduct(order, product.getKey(), product.getValue());
        });

    }


}
