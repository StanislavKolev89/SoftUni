package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.entity.RouteEntity;
import bg.softuni.pathfinder.service.RouteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public List<RouteEntity> findAllRoutes() {
        return routeRepository.findAll();
    }
}
