package com.example.springdataxml.service;

import com.example.springdataxml.model.dto.CategoryExportRootDto;
import com.example.springdataxml.model.dto.CategoryImportDto;
import com.example.springdataxml.model.entity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    void importCategoriesToDatabase(List<CategoryImportDto> categories);

    Set<Category> getRandomCategories();

    CategoryExportRootDto findAllCategoriesWithProductsCount();
}
