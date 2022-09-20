package com.example.testtest.service.impl;


import com.example.testtest.Paths.MyPaths;
import com.example.testtest.model.dto.CategoryImportDto;
import com.example.testtest.model.entity.Category;
import com.example.testtest.repository.CategoryRepository;
import com.example.testtest.service.CategoryService;

import com.example.testtest.util.ValidationUtilImpl;
import com.google.gson.Gson;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORY_OUTPUT_FILE = "category-by-products.json";
    private static final String CATEGORY_FILE = "categories.json";
    private final ValidationUtilImpl validationUtilImpl;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final Gson gson;

    public CategoryServiceImpl(ValidationUtilImpl validationUtilImpl, ModelMapper modelMapper, CategoryRepository categoryRepository, Gson gson) {
        this.validationUtilImpl = validationUtilImpl;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
        this.gson = gson;
    }

    @Override
    public void seedCategories() throws IOException {
        if(categoryRepository.findAll().size()>0){
            return;
        }
       Arrays.stream(gson.fromJson( Files.readString(Path.of(MyPaths.MAIN_PATH_FILES+CATEGORY_FILE)), CategoryImportDto[].class)).
               filter(validationUtilImpl::isValid).map(CategoryImportDto->modelMapper.map(CategoryImportDto, Category.class))
               .forEach(categoryRepository::save);
    }

    @Override
    public Set<Category> getRandomCaregories() {
        Set<Category> categories = new HashSet<>();
       int maxNumberOfCategories = ThreadLocalRandom.current().nextInt(0,categoryRepository.findAll().size()+1);
        Set<Integer> ids = new HashSet<>();
       for (int i =0 ; i<maxNumberOfCategories ; i++){
           int categoryId = ThreadLocalRandom.current().nextInt(0,categoryRepository.findAll().size()+1);
            ids.add(categoryId);
       }
       ids.forEach(id->{
           Category categoryById = categoryRepository.findCategoryById((long) id);
           categories.add(categoryById);
       });
       return  categories;
    }
}
