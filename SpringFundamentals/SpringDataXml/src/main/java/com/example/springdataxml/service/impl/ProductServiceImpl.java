package com.example.springdataxml.service.impl;

import com.example.springdataxml.model.dto.ProductExportDto;
import com.example.springdataxml.model.dto.ProductExportRootDto;
import com.example.springdataxml.model.dto.ProductImportDto;
import com.example.springdataxml.model.entity.Product;
import com.example.springdataxml.repository.ProductRepository;
import com.example.springdataxml.service.CategoryService;
import com.example.springdataxml.service.ProductService;
import com.example.springdataxml.service.UserService;
import com.example.springdataxml.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ValidationUtil validationUtil;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ValidationUtil validationUtil, ProductRepository productRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.validationUtil = validationUtil;
        this.productRepository = productRepository;

        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void importProductsToDatabase(List<ProductImportDto> products) {
        if(productRepository.count()>0){
            return;
        }

        products.stream().filter(validationUtil::isValid).map(productImportDto -> {
                    Product product = modelMapper.map(productImportDto, Product.class);
                    if(product.getPrice().compareTo(BigDecimal.valueOf(600L))<0) {
                        product.setBuyer(userService.getRandomUser());
                    }
                    product.setSeller((userService.getRandomUser()));
                    product.setCategories(categoryService.getRandomCategories());
                    return product;
                }).
                forEach(productRepository::save);
    }

    @Override
    public ProductExportRootDto findAllSoldProducts() {
        ProductExportRootDto productExportRootDto = new ProductExportRootDto();
        List<ProductExportDto> collection = productRepository.findProductsByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L))
                .stream().map(product -> {
                    ProductExportDto productExportDto = modelMapper.map(product, ProductExportDto.class);
                    if(product.getSeller().getFirstName()==null){
                        productExportDto.setSeller(String.format(" %s",
                                product.getSeller().getLastName()));
                    }else {
                        productExportDto.setSeller(String.format("%s %s", product.getSeller().getFirstName(),
                                product.getSeller().getLastName()));
                    }
                    return productExportDto;
                }).collect(Collectors.toList());
        productExportRootDto.setProducts(collection);
        System.out.println();
        return productExportRootDto;
    }
}
