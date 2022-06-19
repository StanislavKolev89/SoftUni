package com.example.battleship.init;

import com.example.battleship.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BattleShipDbInitializer implements CommandLineRunner {

    private final CategoryService categoryService;

    public BattleShipDbInitializer(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public void run(String... args) throws Exception {
        categoryService.initCategories();
    }
}
