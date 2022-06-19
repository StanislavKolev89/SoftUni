package com.example.battleship.service.impl;

import com.example.battleship.entity.CategoryEntity;
import com.example.battleship.entity.CategoryEnum;
import com.example.battleship.repository.CategoryRepository;
import com.example.battleship.service.CategoryService;
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
        Arrays.stream(CategoryEnum.values()).forEach(categoryEnum -> {
            createCategoryInRepo(categoryEnum);
        });
    }

    @Override
    public CategoryEntity findById(long categoryId) {
        CategoryEntity category = categoryRepository.findById(categoryId).orElse(null);

        return  category;
    }


    private void createCategoryInRepo(CategoryEnum categoryEnum) {
        CategoryEntity category = new CategoryEntity();
        category.setName(categoryEnum);
        categoryRepository.save(category);
    }
}
