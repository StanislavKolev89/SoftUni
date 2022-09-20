package com.example.testtest.service.impl;


import com.example.testtest.Paths.MyPaths;
import com.example.testtest.model.dto.ProductExportDto;
import com.example.testtest.model.dto.ProductImportDto;
import com.example.testtest.model.entity.Product;
import com.example.testtest.repository.ProductRepository;
import com.example.testtest.repository.UserRepository;
import com.example.testtest.service.CategoryService;
import com.example.testtest.service.ProductService;
import com.example.testtest.service.UserService;
import com.example.testtest.util.ValidationUtilImpl;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCT_FILE = "products.json";
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final UserRepository userRepository;
    private final ValidationUtilImpl validationUtilImpl;
    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ModelMapper modelMapper, Gson gson, UserRepository userRepository, ValidationUtilImpl validationUtilImpl, ProductRepository productRepository, UserService userService, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.userRepository = userRepository;
        this.validationUtilImpl = validationUtilImpl;
        this.productRepository = productRepository;
        this.userService = userService;

        this.categoryService = categoryService;
    }

    @Override
    public void seedProducts() throws IOException {
        if(productRepository.findAll().size()>0){
            return;
        }
        String s = Files.readString(Path.of(MyPaths.MAIN_PATH_FILES + PRODUCT_FILE));
        Arrays.stream(gson.fromJson((s), ProductImportDto[].class)).filter(validationUtilImpl::isValid).map(productImportDto -> {
            Product product = modelMapper.map(productImportDto, Product.class);
            if (productImportDto.getPrice().compareTo(BigDecimal.valueOf(500L)) < 0) {
                product.setBuyer(null);
            } else {
                product.setBuyer(userService.getRandomUser());
            }

            product.setSeller(userService.getRandomUser());
            product.setCategories(categoryService.getRandomCaregories());
            return product;
        }).forEach(productRepository::save);
    }

    @Override
    public List<ProductExportDto> findAllProductsInRAnge() {
        List<Product> products = productRepository.findProductsByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L));

        return products.stream().map(product -> modelMapper.map(product,ProductExportDto.class)).collect(Collectors.toList());

    }
}
