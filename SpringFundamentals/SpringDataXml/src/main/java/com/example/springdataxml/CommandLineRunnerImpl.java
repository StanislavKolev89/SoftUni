package com.example.springdataxml;

import com.example.springdataxml.model.dto.*;
import com.example.springdataxml.service.CategoryService;
import com.example.springdataxml.service.ProductService;
import com.example.springdataxml.service.UserService;
import com.example.springdataxml.util.ParserXml;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final BufferedReader bufferedReader;
    private final ParserXml parserXml;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private static final String SOURCE_FOLDER = "src/main/resources/files/";
    private static final String OUTPUT_FOLDER = "output/";
    private static final String IMPORT_USERS = "users.xml";
    private static final String IMPORT_CATEGORIES = "categories.xml";
    private static final String IMPORT_PRODUCTS = "products.xml";
    private static final String EXPORT_PRODUCTS_IN_RANGE = "products-in-range.xml";
    private static final String EXPORT_USERS_WITH_PRODUCT_WITH_BUYER = "users-sold-products.xml";
    private static final String EXPORT_CATEGORIES_BY_PRODUCTS = "categories-by-products.xml";
    private static final String EXPORT_USERS_WITH_PRODUCTS = "users-and-products.xml";


    public CommandLineRunnerImpl(ParserXml parserXml, UserService userService, CategoryService categoryService, ProductService productService) {
        this.parserXml = parserXml;
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        System.out.println("ENTER TASK NUMBER: ");
        int numberOfTask = Integer.parseInt(bufferedReader.readLine());

        switch (numberOfTask){
            case 1-> recordProductsInRange();
            case 2-> recordSuccessfullySoldProducts();
            case 3-> recordAllCategoriesByProductsCount();
            case 4-> recordAllUsersWithTheirProducts();
        }
    }

    private void recordAllUsersWithTheirProducts() throws JAXBException {
        UserAndProductExportRootDto userAndProductExportRootDto = userService.findAllUsersWitTheirSoldProducts();
        System.out.println();
        parserXml.writeToFile(SOURCE_FOLDER+OUTPUT_FOLDER+EXPORT_USERS_WITH_PRODUCTS,userAndProductExportRootDto);

    }

    private void recordAllCategoriesByProductsCount() throws JAXBException {
        CategoryExportRootDto categoryExportRootDto = categoryService.findAllCategoriesWithProductsCount();
      parserXml.writeToFile(SOURCE_FOLDER+OUTPUT_FOLDER+EXPORT_CATEGORIES_BY_PRODUCTS,categoryExportRootDto);
    }

    private void recordSuccessfullySoldProducts() throws JAXBException {
        UserExportRootDto userExportRootDto = userService.findAllUsersWithSoldProducts();
        parserXml.writeToFile(SOURCE_FOLDER+OUTPUT_FOLDER+ EXPORT_USERS_WITH_PRODUCT_WITH_BUYER,userExportRootDto);
    }

    private void seedData() throws JAXBException, IOException {
        seedUsers();
        seedCategories();
    seedProduct();



    }

    private void recordProductsInRange() throws JAXBException {
        ProductExportRootDto allSoldProducts = productService.findAllSoldProducts();
        System.out.println();
            parserXml.writeToFile(SOURCE_FOLDER+OUTPUT_FOLDER+EXPORT_PRODUCTS_IN_RANGE,allSoldProducts);
    }

    private void seedProduct() throws JAXBException, FileNotFoundException {
        ProductImportRootDto productImportRootDto = parserXml.extractFromFile((SOURCE_FOLDER+IMPORT_PRODUCTS),ProductImportRootDto.class);
        System.out.println();
        productService.importProductsToDatabase(productImportRootDto.getProducts());

    }

    private void seedCategories() throws JAXBException, FileNotFoundException {
        CategoryImportRootDto categoryImportRootDto = parserXml.extractFromFile((SOURCE_FOLDER+IMPORT_CATEGORIES),CategoryImportRootDto.class);
        categoryService.importCategoriesToDatabase(categoryImportRootDto.getCategories());
    }

    private void seedUsers() throws JAXBException, FileNotFoundException {
        UserImportRootDto userImportRootDto = parserXml.extractFromFile(SOURCE_FOLDER + IMPORT_USERS, UserImportRootDto.class);
       userService.importUsersToDatabase(userImportRootDto.getUsers());


    }
}
