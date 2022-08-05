package bg.softuni.personalproject.service;

import bg.softuni.personalproject.exception.ObjectNotFoundException;
import bg.softuni.personalproject.model.dto.CategoryDTO;
import bg.softuni.personalproject.model.dto.QuantityHolderDTO;
import bg.softuni.personalproject.model.entity.ProductEntity;
import bg.softuni.personalproject.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.error.ShouldBeUnmodifiable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.instrument.UnmodifiableClassException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShoppingCartServiceTest {

    @InjectMocks
    private ShoppingCartService mockService;

    @Mock
    private  ProductRepository productRepository;

    @Mock
    private OrderService orderService;
    @Mock
    private  UserService userService;

    private Map<ProductEntity, Integer> cartProducts = new HashMap<>();

    private QuantityHolderDTO quantityHolder = new QuantityHolderDTO();

    private ProductEntity product = new ProductEntity();

    @BeforeEach
    void setUp(){
        quantityHolder.setQuantity(10);
        product.setPrice(BigDecimal.TEN);
    }
    @Test
    void addToCart() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        mockService.addToCart(1L,quantityHolder);

    }

    @Test
    void finishOrder() {
        mockService.finishOrder("GOSHO");
    }

    @Test
    void pricePerProduct() {
         cartProducts.put(product, quantityHolder.getQuantity());
        Map.Entry<ProductEntity,Integer> entry = cartProducts.entrySet().iterator().next();
        BigDecimal bigDecimal = mockService.pricePerProduct(entry);
        Assertions.assertThat(bigDecimal).isEqualTo(BigDecimal.valueOf(100));
    }

    @Test
    void findTotalSum() {
        cartProducts.put(product, quantityHolder.getQuantity());
        BigDecimal totalSum = mockService.findTotalSum();
        Assertions.assertThat(totalSum).isEqualTo(BigDecimal.valueOf(0));
    }

    @Test
    void getAllProducts() {
        Map<ProductEntity, Integer> allProducts = mockService.getAllProducts();
    }

    @Test
    void removeProduct() {

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        cartProducts.put(product, quantityHolder.getQuantity());
        mockService.removeProduct(1L);
    }

    @Test
    void removeProductThrowException() {
        when(productRepository.findById(1L)).thenReturn(null);
        org.junit.jupiter.api.Assertions.assertThrows(ObjectNotFoundException.class, () ->
               mockService.removeProduct(1L));
    }
}