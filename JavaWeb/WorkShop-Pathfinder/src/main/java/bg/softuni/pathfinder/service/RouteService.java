package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.entity.RouteEntity;

import java.util.List;

public interface RouteService {
    List<RouteEntity> findAllRoutes();
}
