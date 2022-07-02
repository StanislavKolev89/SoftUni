package com.example.coffeeshopapplication.model.view;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderViewModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private String enumName;
}
