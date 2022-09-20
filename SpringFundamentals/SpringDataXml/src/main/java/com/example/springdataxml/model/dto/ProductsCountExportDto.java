package com.example.springdataxml.model.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsCountExportDto {

    @XmlAttribute(name = "count")
    private int count;

    @XmlElement(name = "product")
    private List<ProductWithNameAndPriceExportDto> products;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ProductWithNameAndPriceExportDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductWithNameAndPriceExportDto> products) {
        this.products = products;
    }



}
