package com.example.battleship.service;

import com.example.battleship.entity.CategoryEntity;

public interface CategoryService {

    void initCategories();


    CategoryEntity findById(long categoryId);
}
