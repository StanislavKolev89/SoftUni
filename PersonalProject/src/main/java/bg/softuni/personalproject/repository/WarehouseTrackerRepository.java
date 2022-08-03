package bg.softuni.personalproject.repository;

import bg.softuni.personalproject.model.entity.ProductQuantityTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseTrackerRepository extends JpaRepository<ProductQuantityTracker,Long> {
}
