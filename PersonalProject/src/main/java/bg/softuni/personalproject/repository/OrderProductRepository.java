package bg.softuni.personalproject.repository;

import bg.softuni.personalproject.model.entity.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProductEntity, Long> {

    @Query("SELECT o FROM OrderProductEntity o where o.order.user.id=:id")
    List<OrderProductEntity> findAllOrdersByUserId(@Param("id") Long id);


    List<OrderProductEntity> findOrderProductEntitiesByOrder_Id(Long orderId);
}
