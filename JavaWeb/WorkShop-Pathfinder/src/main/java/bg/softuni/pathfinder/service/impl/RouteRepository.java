package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<RouteEntity,Long> {
}
