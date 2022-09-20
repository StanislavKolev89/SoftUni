package com.example.springdataxml.model.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserExportDto {

    @XmlAttribute(name ="first-name")
    private String firstName;

    @XmlAttribute(name ="last-name")
    private String lastName;

    public List<ProductExportWithBuyerDto> getProductsAll() {
        return productsAll;
    }

    public void setProductsAll(List<ProductExportWithBuyerDto> productsAll) {
        this.productsAll = productsAll;
    }

    @XmlElementWrapper(name ="sold-products")
    @XmlElement(name = "product")
    private List<ProductExportWithBuyerDto> productsAll;




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


}
