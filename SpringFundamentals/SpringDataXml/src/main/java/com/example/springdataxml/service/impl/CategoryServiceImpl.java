package com.example.springdataxml.service.impl;

import com.example.springdataxml.model.dto.CategoryExportDto;
import com.example.springdataxml.model.dto.CategoryExportRootDto;
import com.example.springdataxml.model.dto.CategoryImportDto;
import com.example.springdataxml.model.entity.Category;
import com.example.springdataxml.model.entity.Product;
import com.example.springdataxml.repository.CategoryRepository;
import com.example.springdataxml.service.CategoryService;
import com.example.springdataxml.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public void importCategoriesToDatabase(List<CategoryImportDto> categories) {
        if(categoryRepository.count()>0){
            return;
        }
        categories.stream().filter(validationUtil::isValid).map(categoryImportDto -> modelMapper.map(categoryImportDto, Category.class)).
                forEach(categoryRepository::save);

    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();
        long categoryCount = categoryRepository.count();

        for (int i = 0; i < 3; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(0,categoryCount+1);
            categories.add(categoryRepository.findById(randomId).orElse(null));
        }
        return categories;
    }

    @Override
    public CategoryExportRootDto findAllCategoriesWithProductsCount() {
        CategoryExportRootDto categoryExportRootDto = new CategoryExportRootDto();
        List<CategoryExportDto> collection = categoryRepository.getAllByCountOfProductsOrderByCount().stream().map(category -> {
            CategoryExportDto categoryExportDto = modelMapper.map(category, CategoryExportDto.class);
            categoryExportDto.setProductsCount(category.getProducts().size());
            categoryExportDto.setAveragePrice(findAveragePrice(category.getProducts()));
            categoryExportDto.setTotalSum(findTotalSumOfProducts(category.getProducts()));

            return categoryExportDto;
        }).collect(Collectors.toList());
        categoryExportRootDto.setAllProducts(collection);

        return categoryExportRootDto;
    }

    private BigDecimal findTotalSumOfProducts(Set<Product> products) {
        BigDecimal totalSum = BigDecimal.ZERO;
        for (Product product : products) {
            totalSum = totalSum.add(product.getPrice());
        }

        return totalSum;
    }

    private BigDecimal findAveragePrice(Set<Product> products) {
        BigDecimal totalSum = BigDecimal.ZERO;
        for (Product product : products) {
            totalSum = totalSum.add(product.getPrice());
        }
        BigDecimal prCount = new BigDecimal(products.size());
        BigDecimal avg = totalSum.divide(prCount,2, RoundingMode.HALF_UP);
        return avg;
    }
}
