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
        switch (categoryEnum) {
            case CAKE -> createCategory(CategoryEnum.CAKE, 10);
            case DRINK -> createCategory(CategoryEnum.DRINK, 1);
            case COFFEE -> createCategory(CategoryEnum.COFFEE, 2);
            case OTHER -> createCategory(CategoryEnum.OTHER, 5);
        }
    }

    private void createCategory(CategoryEnum other, int neededTime) {
        categoryRepository.save(CategoryEntity.builder()
                .name(other)
                .neededTime(neededTime)
                .build());
    }
}
