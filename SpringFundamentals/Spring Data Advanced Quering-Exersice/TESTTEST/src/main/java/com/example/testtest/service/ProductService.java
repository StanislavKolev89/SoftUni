package com.example.testtest.service;

import com.example.testtest.model.dto.ProductExportDto;
import org.springframework.data.jpa.repository.Query;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    void seedProducts() throws IOException;

    List<ProductExportDto> findAllProductsInRAnge();
}
