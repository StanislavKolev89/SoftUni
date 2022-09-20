package com.example.springdatamappingexercise.model.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

public class EditGameDto {
    private Long id;
    @DecimalMin(value = "0.0", inclusive = false, message = "Enter valid price")
    private BigDecimal price;
    @Min(value = 0)
    private double size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public EditGameDto(Long id, BigDecimal price, double size) {
        this.id = id;
        this.price = price;
        this.size = size;
    }


}
