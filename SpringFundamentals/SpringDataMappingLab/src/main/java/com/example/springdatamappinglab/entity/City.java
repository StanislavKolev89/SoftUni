package com.example.springdatamappinglab.entity;

import javax.persistence.*;


public class City {

    private Long id;

    private String name;
    private String country;
    private Long citizens;

    public City() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getCitizens() {
        return citizens;
    }

    public void setCitizens(Long citizens) {
        this.citizens = citizens;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City( String name,String country, Long citizens) {
        this.name = name;
        this.country = country;
        this.citizens = citizens;
    }
}
