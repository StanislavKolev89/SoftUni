package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.dto.OrderDTO;
import bg.softuni.personalproject.model.dto.UserLoginDTO;
import bg.softuni.personalproject.model.entity.OrderEntity;
import bg.softuni.personalproject.model.entity.ProductEntity;
import bg.softuni.personalproject.model.entity.UserEntity;
import bg.softuni.personalproject.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    private final OrderProductService orderProductService;

    //    ToDO Pass user To The Order and make (nullable=false) User in OrderEntity
    //      if buyer is null do nothing! Not so sure about that
    public void createOrder(Map<ProductEntity, Integer> cartItems, UserEntity buyer) {
        OrderEntity order = new OrderEntity();
        if (buyer != null) {
            order.setUser(buyer);
            order.setDate(LocalDateTime.now());
            orderRepository.save(order);
            cartItems.entrySet().stream().forEach(product -> {

                orderProductService.addOrderAndProduct(order, product.getKey(), product.getValue());
            });

        }
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(orderEntity-> modelMapper.map(orderEntity,OrderDTO.class)).collect(Collectors.toList());
    }
    //ToDo decide what exception to throw

    //Usage in template
    public BigDecimal getTotalPriceOfOrder(Long orderId) {
        return orderProductService.findAllOrderProducts(orderId).stream().
                map(order -> order.getProduct().getPrice().multiply(BigDecimal.valueOf(order.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

    }

    public void deleteOrder(Long id) {
        OrderEntity order = orderRepository.findById(id).orElse(null);
            order.setDeleted(true);

    }
}
