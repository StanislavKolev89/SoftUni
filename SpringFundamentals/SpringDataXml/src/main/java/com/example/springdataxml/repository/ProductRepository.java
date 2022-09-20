package com.example.springdataxml.repository;

import com.example.springdataxml.model.dto.ProductExportDto;
import com.example.springdataxml.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findProductsByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal lower,BigDecimal higher);
}
