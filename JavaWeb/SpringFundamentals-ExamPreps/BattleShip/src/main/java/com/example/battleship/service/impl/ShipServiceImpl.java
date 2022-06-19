package com.example.battleship.service.impl;

import com.example.battleship.entity.ShipEntity;
import com.example.battleship.entity.service.ShipAddServiceModel;
import com.example.battleship.entity.view.ShipViewModel;
import com.example.battleship.repository.CategoryRepository;
import com.example.battleship.repository.ShipRepository;
import com.example.battleship.service.CategoryService;
import com.example.battleship.service.ShipService;
import com.example.battleship.service.UserService;
import com.example.battleship.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final CategoryService categoryService;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, CurrentUser currentUser, CategoryRepository categoryRepository, CategoryService categoryService, UserService userService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.categoryService = categoryService;

        this.userService = userService;

    }

    private final UserService userService;

    @Override
    public void addShip(ShipAddServiceModel shipAddServiceModel) {
        ShipEntity shipEntity = new ShipEntity();
        shipEntity.setName(shipAddServiceModel.getName());
        shipEntity.setPower(shipAddServiceModel.getPower());
        shipEntity.setHealth(shipAddServiceModel.getHealth());
        shipEntity.setCreated(shipAddServiceModel.getCreated());

        long categoryId = getCategoryId(shipAddServiceModel.getCategory());
        shipEntity.setCategory(categoryService.findById(categoryId));
        shipEntity.setUser(userService.findUserById(currentUser.getId()));
        shipRepository.save(shipEntity);
    }

    @Override
    public boolean existsByName(String name) {
        return shipRepository.existsByName(name);
    }

    @Override
    public List<ShipViewModel> findAllShipsOfLoggedUser() {
        return shipRepository.findAllByUserId(currentUser.getId()).stream().map(shipEntity -> modelMapper.map(shipEntity, ShipViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModel> findAllOtherShips() {
        return shipRepository.findAllNotHavingUserId(currentUser.getId()).stream().filter(shipEntity ->shipEntity.getId()!=currentUser.getId()).map(
                shipEntity -> modelMapper.map(shipEntity,ShipViewModel.class)).
                collect(Collectors.toList());
    }

    @Override
    public void attack(String attackerName, String defenderName) {
        ShipEntity attackerEntity = shipRepository.getByName(attackerName);
        ShipEntity defenderEntity = shipRepository.getByName(defenderName);
        long defenderRemainingHealth = defenderEntity.getHealth() - attackerEntity.getPower();
        if (defenderRemainingHealth <= 0) {
            shipRepository.delete(defenderEntity);
        } else {
            defenderEntity.setHealth(defenderRemainingHealth);
            shipRepository.save(defenderEntity);
        }
    }


    private long getCategoryId(String category) {
        long id = 0;
        switch (category) {
            case "BATTLE":
                id = 1;
                break;
            case "CARGO":
                id = 2;
                break;
            case "PATROL": id = 3;
            break;
        }
        return id;
    }


}
