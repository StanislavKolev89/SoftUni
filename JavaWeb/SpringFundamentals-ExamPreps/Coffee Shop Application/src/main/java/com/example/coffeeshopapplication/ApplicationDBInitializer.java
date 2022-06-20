package com.example.coffeeshopapplication;

import com.example.coffeeshopapplication.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationDBInitializer implements CommandLineRunner {

    private final CategoryService categoryService;

    public ApplicationDBInitializer(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.initCategories();
    }
}
