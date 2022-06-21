package com.example.coffeeshopapplication.service.impl;

import com.example.coffeeshopapplication.model.entity.CategoryEntity;
import com.example.coffeeshopapplication.model.enums.CategoryEnum;
import com.example.coffeeshopapplication.repository.CategoryRepository;
import com.example.coffeeshopapplication.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() > 0) {
            return;
        }
        Arrays.stream(CategoryEnum.values()).forEach(categoryEnum -> createAndSaveCategory(categoryEnum));
    }

    @Override
    public CategoryEntity findCategoryByEnumName(CategoryEnum name) {
        return categoryRepository.findByName(name).orElse(null);
    }

    private void createAndSaveCategory(CategoryEnum categoryEnum) {
        CategoryEntity categoryEntity = new CategoryEntity();
        switch (categoryEnum) {
            case CAKE -> categoryEntity.setName(CategoryEnum.CAKE).setNeededTime(10);
            case DRINK -> categoryEntity.setName(CategoryEnum.DRINK).setNeededTime(1);
            case COFFEE -> categoryEntity.setName(CategoryEnum.COFFEE).setNeededTime(2);
            case OTHER -> categoryEntity.setName(CategoryEnum.OTHER).setNeededTime(5);
        }
        categoryRepository.save(categoryEntity);
    }
}
