package com.example.springdataxml.service;

import com.example.springdataxml.model.dto.ProductExportRootDto;
import com.example.springdataxml.model.dto.ProductImportDto;

import java.util.List;

public interface ProductService {

    void importProductsToDatabase(List<ProductImportDto> products);

    ProductExportRootDto findAllSoldProducts();
}
