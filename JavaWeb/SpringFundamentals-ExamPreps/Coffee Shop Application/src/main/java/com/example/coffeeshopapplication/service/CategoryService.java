package com.example.coffeeshopapplication.service;

import com.example.coffeeshopapplication.model.entity.CategoryEntity;
import com.example.coffeeshopapplication.model.enums.CategoryEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findCategoryByEnumName(CategoryEnum name);
}
