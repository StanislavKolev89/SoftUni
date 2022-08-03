package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.OrderEntity;
import bg.softuni.personalproject.model.entity.OrderProductEntity;
import bg.softuni.personalproject.model.entity.ProductEntity;
import bg.softuni.personalproject.repository.OrderProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderProductServiceTest {

    @Mock
    private OrderProductRepository orderProductRepository;

    @InjectMocks
    private OrderProductService mockedService;

    private ProductEntity product;

    private OrderEntity order;

    private OrderProductEntity orderProductEntity;

    @BeforeEach
    void setUp() {
        product = new ProductEntity();
        product.setTitle("DRILL");
        product.setPrice(BigDecimal.TEN);
        order = new OrderEntity();
        order.setCreatedAt(LocalDateTime.now());
        orderProductEntity = new OrderProductEntity();

    }

//    @Test
//    void addOrderAndProduct() {
//       verify(mockedService.addOrderAndProduct(order,product,2));
//    }

    @Test
    void findAllUsersProducts() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findAllOrderProducts() {
    }

    @Test
    void pricePerProduct() {
    }

    @Test
    void findTurnover() {
    }

    @Test
    void deleteByOrderId() {
    }
}