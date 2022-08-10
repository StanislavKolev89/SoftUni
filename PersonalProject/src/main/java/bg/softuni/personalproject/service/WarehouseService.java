package bg.softuni.personalproject.service;

import bg.softuni.personalproject.exception.ObjectNotFoundException;
import bg.softuni.personalproject.model.entity.ProductEntity;
import bg.softuni.personalproject.model.entity.ProductQuantityTracker;
import bg.softuni.personalproject.repository.WarehouseTrackerRepository;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class WarehouseService {

    private final WarehouseTrackerRepository warehouseTrackerRepository;

    public void decreaseStock(Long id, Integer value) {
        warehouseTrackerRepository.findById(id)
              .ifPresent(quantityTracker -> {
                  quantityTracker.setQuantity(quantityTracker.getQuantity() - value);
                  warehouseTrackerRepository.save(quantityTracker);
              });
    }

    public int itemsLeft(Long id) {
        return warehouseTrackerRepository.findById(id)
              .map(ProductQuantityTracker::getQuantity)
              .orElse(0);
    }

    @Scheduled(cron = "* */1  * * * *")
    public void alertIfInventoryLow() {

        List<ProductQuantityTracker> trackers = warehouseTrackerRepository.findAll().stream()
              .filter(productQuantityTracker -> productQuantityTracker.getQuantity() < 20)
              .toList();
        if (!trackers.isEmpty()) {
            throw new IllegalArgumentException("You have to check stock on hand and reorder if needed   ");
        }
    }

    @Scheduled(cron = "* */5 * * * *")
    public void trackInventory() {
        StringBuilder builder = new StringBuilder();
        warehouseTrackerRepository.findAll()
              .forEach(product -> builder.append(String.format("PRODUCT %s -> Quantity %d ", product.getProduct().getTitle(), product.getQuantity()))
                    .append(System.lineSeparator()));
        log.info(builder.toString());
    }

    public void saveNewProduct(ProductEntity productEntity) {
        ProductQuantityTracker productQuantityTracker = new ProductQuantityTracker();
        productQuantityTracker.setProduct(productEntity);
        productQuantityTracker.setQuantity(100);
        warehouseTrackerRepository.save(productQuantityTracker);
    }

    public void deleteProduct(Long id) {
        warehouseTrackerRepository.deleteById(id);
    }


    public void restoreQuantityOfProduct(ProductEntity product, int quantity) {
        ProductQuantityTracker prTracker = warehouseTrackerRepository.findById(product.getId())
                .orElseThrow(ObjectNotFoundException::new);
        prTracker.setQuantity(prTracker.getQuantity()+quantity);
    }
}
