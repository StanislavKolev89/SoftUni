package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.OrderEntity;
import bg.softuni.personalproject.model.entity.ProductEntity;
import bg.softuni.personalproject.model.entity.UserEntity;
import bg.softuni.personalproject.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    private final OrderProductService orderProductService;

    //    ToDO Pass user To The Order and make (nullable=false) User in OrderEntity
    //      if buyer is null do nothing! Not so sure about that
    public void createOrder(Map<ProductEntity, Integer> cartItems, UserEntity buyer) {
        OrderEntity order = new OrderEntity().date(LocalDateTime.now());
        if (buyer != null) {
            order.user(buyer);
            orderRepository.save(order);
            cartItems.entrySet().stream().forEach(product -> {

                orderProductService.addOrderAndProduct(order, product.getKey(), product.getValue());
            });

        }
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }
}
