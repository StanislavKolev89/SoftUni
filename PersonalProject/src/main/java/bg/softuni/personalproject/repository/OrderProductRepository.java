package bg.softuni.personalproject.repository;

import bg.softuni.personalproject.model.entity.model.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProductEntity, Long> {

}
