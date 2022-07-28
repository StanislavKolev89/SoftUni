package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.OrderEntity;
import bg.softuni.personalproject.model.entity.OrderProductEntity;
import bg.softuni.personalproject.model.entity.ProductEntity;
import bg.softuni.personalproject.repository.OrderProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderProductService {

    private final OrderProductRepository orderProductRepository;

    public void addOrderAndProduct(OrderEntity order, ProductEntity product, Integer quantity) {

        orderProductRepository.save(new OrderProductEntity().order(order).product(product).quantity(quantity));
    }


    public List<OrderProductEntity> findAllUsersProducts(Long id) {
        return orderProductRepository.findAllOrdersByUserId(id);
    }

    public List<OrderProductEntity> findAll() {
        return orderProductRepository.findAll();
    }

    public List<OrderProductEntity> findAllOrderProducts(Long orderId) {
        return orderProductRepository.findOrderProductEntitiesByOrder_Id(orderId);
    }

    //Usage in template
    public BigDecimal pricePerProduct(OrderProductEntity orderProductEntity) {
        return orderProductEntity.product().price().multiply(BigDecimal.valueOf(orderProductEntity.quantity()));
    }

    public BigDecimal findTurnover() {
        return orderProductRepository.findAll().stream().filter(orderProductEntity -> orderProductEntity.order().user().getId() != 1).
                map(order -> order.product().price().multiply(BigDecimal.valueOf(order.quantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
