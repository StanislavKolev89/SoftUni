package com.example.springdataxml.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryExportRootDto {
    @XmlElement(name = "category")
    private List<CategoryExportDto> allProducts;


    public List<CategoryExportDto> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<CategoryExportDto> allProducts) {
        this.allProducts = allProducts;
    }


}
