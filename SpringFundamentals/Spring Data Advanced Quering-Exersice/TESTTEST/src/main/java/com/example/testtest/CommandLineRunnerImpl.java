package com.example.testtest;

import com.example.testtest.Paths.MyPaths;
import com.example.testtest.model.dto.ProductExportDto;
import com.example.testtest.model.dto.UserExportDto;
import com.example.testtest.service.CategoryService;
import com.example.testtest.service.ProductService;
import com.example.testtest.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;


        @Component
        public class CommandLineRunnerImpl implements CommandLineRunner {
            private final BufferedReader bufferedReader;
            private static final String PRODUCT_IN_RANGE_OUTPUT_FILE = "products-in-range.json";
            private static final String USER_SOLD_PRODUCT_OUTPUT_FILE = "users-sold-products.json";
            private static final String USERS_AND_PRODUCTS_OUTPUT_FILE = "users-and-products.json";
            private final UserService userService;
            private final CategoryService categoryService;
            private final ProductService productService;
            private final Gson gson;

            @Autowired
            public CommandLineRunnerImpl(UserService userService, CategoryService categoryService, ProductService productService, Gson gson) {
                this.gson = gson;
                this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                this.userService = userService;
                this.categoryService = categoryService;
                this.productService = productService;
            }

            @Override
            public void run(String... args) throws Exception {
                seedData();
                System.out.println("Enter task number:");
                int number = Integer.parseInt(bufferedReader.readLine());
                switch (number) {
                    case 1 -> recordProductsInRange();
                    case 2 -> recordUsersWithSoldProduct();
                }
            }

            private void recordUsersWithSoldProduct() throws IOException {
                List<UserExportDto> userDtos = userService.findAllUsersWithSoldProducts();
                String usersToJson = gson.toJson(userDtos);
                writeToFile(usersToJson, MyPaths.OUTPUT_PATH + USER_SOLD_PRODUCT_OUTPUT_FILE);
            }

            private void recordProductsInRange() throws IOException {
                List<ProductExportDto> productDtos = productService.findAllProductsInRAnge();

                String productsToJson = gson.toJson(productDtos);
                writeToFile(productsToJson, MyPaths.OUTPUT_PATH + PRODUCT_IN_RANGE_OUTPUT_FILE);
            }

            private void writeToFile(String productInRange, String path) throws IOException {
                Files.write(Path.of(path), Collections.singleton(productInRange));
            }

            private void seedData() throws IOException {
                userService.SeedUsers();
                categoryService.seedCategories();
                productService.seedProducts();

            }
        }


