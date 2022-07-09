package bg.softuni.personalproject.repository;

import bg.softuni.personalproject.model.entity.model.OrderProductEntity;
import bg.softuni.personalproject.model.entity.model.OrderProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProductEntity, OrderProductKey> {

}
