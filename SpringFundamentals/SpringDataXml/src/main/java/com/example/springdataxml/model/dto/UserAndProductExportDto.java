package com.example.springdataxml.model.dto;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAndProductExportDto {

    @XmlAttribute(name ="first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlElement(name = "sold-products")
    private ProductsCountExportDto productsCountExportDto;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ProductsCountExportDto getProductsCountExportDto() {
        return productsCountExportDto;
    }

    public void setProductsCountExportDto(ProductsCountExportDto productsCountExportDto) {
        this.productsCountExportDto = productsCountExportDto;
    }


}
