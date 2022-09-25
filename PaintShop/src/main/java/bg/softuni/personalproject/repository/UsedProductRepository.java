package bg.softuni.personalproject.repository;

import bg.softuni.personalproject.model.entity.UsedProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsedProductRepository extends JpaRepository<UsedProductEntity, Long> {
}
