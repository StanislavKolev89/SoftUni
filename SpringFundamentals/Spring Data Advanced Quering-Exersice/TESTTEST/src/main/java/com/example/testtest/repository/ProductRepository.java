package com.example.testtest.repository;


import com.example.testtest.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findProductsByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal lowerRange, BigDecimal higherRange);
}
