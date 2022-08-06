package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.ProductEntity;
import bg.softuni.personalproject.model.entity.ProductQuantityTracker;
import bg.softuni.personalproject.repository.WarehouseTrackerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class WarehouseServiceTest {

    @InjectMocks
    private WarehouseService mockedService;

    @Mock
    private WarehouseTrackerRepository warehouseTrackerRepository;

    private ProductQuantityTracker productQuantityTrackerOne = new ProductQuantityTracker();

    private ProductQuantityTracker productQuantityTrackerTwo = new ProductQuantityTracker();

    private Logger LOGGER = LoggerFactory.getLogger(WarehouseService.class);

    private ProductEntity productOne = new ProductEntity();

    private ProductEntity productTwo = new ProductEntity();


    @BeforeEach
    void setUp() {
        productOne.setId(1L);
        productOne.setTitle("DRILL");
        productQuantityTrackerOne.setQuantity(100);
        productQuantityTrackerOne.setId(1L);
        productQuantityTrackerOne.setProduct(productOne);

        productQuantityTrackerTwo.setQuantity(100);
        productQuantityTrackerTwo.setId(2L);
        productQuantityTrackerTwo.setProduct(productTwo);
    }

    @Test
    void decreaseStock() {
        Mockito.when(warehouseTrackerRepository.findById(1L)).thenReturn(Optional.of(productQuantityTrackerOne));
        mockedService.decreaseStock(1L,10);
    }

    @Test
    void itemsLeft() {
        Mockito.when(warehouseTrackerRepository.findById(1L)).thenReturn(Optional.of(productQuantityTrackerOne));
        int itemsLeft = mockedService.itemsLeft(1L);
        Assertions.assertThat(itemsLeft).isEqualTo(100);
    }

    @Test
    void alertIfInventoryLowNotThrowingException() {
        Mockito.when(warehouseTrackerRepository.findAll()).thenReturn(List.of(productQuantityTrackerOne,productQuantityTrackerTwo));
        mockedService.alertIfInventoryLow();
    }

    @Test
    void alertIfInventoryLowThrowingException() {
        productQuantityTrackerOne.setQuantity(15);
        productQuantityTrackerTwo.setQuantity(17);
        Mockito.when(warehouseTrackerRepository.findAll()).thenReturn(List.of(productQuantityTrackerOne,productQuantityTrackerTwo));
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () ->
                mockedService.alertIfInventoryLow());
    }
    @Test
    void trackInventory() {
        Mockito.when(warehouseTrackerRepository.findAll()).thenReturn(List.of(productQuantityTrackerOne,productQuantityTrackerTwo));
        mockedService.trackInventory();
    }
}