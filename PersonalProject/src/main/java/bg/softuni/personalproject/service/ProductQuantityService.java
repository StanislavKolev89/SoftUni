package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.ProductQuantityTracker;
import bg.softuni.personalproject.repository.ProductQuantityTrackerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductQuantityService {

    private Logger LOGGER = LoggerFactory.getLogger(ProductQuantityService.class);
    private final ProductQuantityTrackerRepository productQuantityTrackerRepository;

    public ProductQuantityService(ProductQuantityTrackerRepository productQuantityTrackerRepository) {
        this.productQuantityTrackerRepository = productQuantityTrackerRepository;
    }

    public void decreaseStock(Long id, Integer value) {
        ProductQuantityTracker productQuantityTracker = productQuantityTrackerRepository.findById(id).get();
        productQuantityTracker.setQuantity(productQuantityTracker.getQuantity() - value);
        productQuantityTrackerRepository.save(productQuantityTracker);
    }

    public int itemsLeft(Long id){
        ProductQuantityTracker productQuantityTracker = productQuantityTrackerRepository.findById(id).get();
        return productQuantityTracker.getQuantity();

    }
    @Scheduled(cron = "* 1 * * * *")
    public void alertIfInventoryLow() {

        List<ProductQuantityTracker> trackers = productQuantityTrackerRepository.findAll()
                .stream().filter(productQuantityTracker -> productQuantityTracker.getQuantity() < 20)
                .collect(Collectors.toList());
        if (!trackers.isEmpty()) {
            throw new IllegalArgumentException("You have to check stock on hand and reorder if needed");
        }
    }

    @Scheduled(cron = "* 1 * * * *")
    public void trackInventory() {
        StringBuilder builder = new StringBuilder();
        productQuantityTrackerRepository.findAll().stream()
                .forEach(product -> builder.append(String.format("PRODUCT %s -> Quantity %d ", product.getProduct().getTitle(), product.getQuantity()))
                        .append(System.lineSeparator()));
        LOGGER.info(builder.toString());

    }

}
