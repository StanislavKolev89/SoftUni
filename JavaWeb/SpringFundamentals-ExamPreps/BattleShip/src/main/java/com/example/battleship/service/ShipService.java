package com.example.battleship.service;

import com.example.battleship.entity.view.ShipViewModel;
import com.example.battleship.entity.service.ShipAddServiceModel;

import java.util.List;

public interface ShipService {
    void addShip(ShipAddServiceModel shipAddServiceModel);

    boolean existsByName(String name);

    List<ShipViewModel> findAllShipsOfLoggedUser();

    List<ShipViewModel> findAllOtherShips();

    void attack(String attackerName, String defenderName);
}
