package bg.softuni.personalproject.service;

import bg.softuni.personalproject.exception.ObjectNotFoundException;
import bg.softuni.personalproject.model.dto.OrderDTO;
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
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final WarehouseService productQuantityService;

    private final OrderProductService orderProductService;

    //    ToDO Pass user To The Order and make (nullable=false) User in OrderEntity
    //      if buyer is null do nothing! Not so sure about that
    public void createOrder(Map<ProductEntity, Integer> cartItems, UserEntity buyer) {
        OrderEntity order = new OrderEntity();
        order.setUser(buyer);
        order.setCreatedAt(LocalDateTime.now());
        orderRepository.save(order);
        cartItems.forEach((product, orderedItemsCount) -> {
            orderProductService.addOrderAndProduct(order, product, orderedItemsCount);
            productQuantityService.decreaseStock(product.getId(), orderedItemsCount);
        });
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream().filter(orderEntity -> !orderEntity.isDeleted()).map(orderEntity -> {
            OrderDTO orderDTO = modelMapper.map(orderEntity, OrderDTO.class);
            orderDTO.setUser(orderEntity.getUser().getEmail());
            return orderDTO;
        }).collect(Collectors.toList());
    }

    public BigDecimal getTotalPriceOfOrder(Long orderId) {
        return orderProductService.findAllOrderProducts(orderId).stream().
                map(order -> order.getProduct().getPrice().multiply(BigDecimal.valueOf(order.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

    }

    public void deleteOrder(Long id) {
        OrderEntity order = orderRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
        orderProductService.deleteByOrderId(id);
        order.setDeleted(true);
        orderRepository.save(order);

    }

    public boolean buyerIsAdmin(String username) {
        return userService.findByName(username).getId()==1;
    }
}
