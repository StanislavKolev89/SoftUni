package com.example.springdataxml.model.dto;


import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name= "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryImportDto {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryImportDto() {
    }

    @XmlElement( name = "name")
    @Size(min=3, max =15)
    private String name;
}
