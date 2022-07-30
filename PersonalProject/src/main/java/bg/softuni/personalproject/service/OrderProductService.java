package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.OrderEntity;
import bg.softuni.personalproject.model.entity.OrderProductEntity;
import bg.softuni.personalproject.model.entity.ProductEntity;
import bg.softuni.personalproject.repository.OrderProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class OrderProductService {

    private final OrderProductRepository orderProductRepository;

    public void addOrderAndProduct(OrderEntity order, ProductEntity product, Integer quantity) {

        OrderProductEntity orderProductEntity = new OrderProductEntity();
        orderProductEntity.setOrder(order);
        orderProductEntity.setProduct(product);
        orderProductEntity.setQuantity(quantity);
        orderProductRepository.save(orderProductEntity);
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
        return orderProductEntity.getProduct().getPrice().multiply(BigDecimal.valueOf(orderProductEntity.getQuantity()));
    }

    public BigDecimal findTurnover() {
        return orderProductRepository.findAll().stream().filter(orderProductEntity -> orderProductEntity.getOrder().getUser().getId() != 1).
                filter(orderProductEntity -> orderProductEntity.getOrder().isDeleted()==false).
                map(orderProductEntity -> orderProductEntity.getProduct().getPrice().multiply(BigDecimal.valueOf(orderProductEntity.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }


    public void deleteByOrderId(Long id) {
        orderProductRepository.deleteAllOrdersProductEntitiesByOrderId(id);
    }
}
