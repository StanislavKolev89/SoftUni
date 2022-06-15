package com.example.moblilelele.model.dto;

import com.example.moblilelele.model.enums.EngineType;
import com.example.moblilelele.model.enums.TransmissionType;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class OfferDto {

    @NotNull(message = "Model is required.")
    private ModelDto modelDto;

    @Positive(message="Please enter price.")
    private BigDecimal price;

    @NotNull(message = "Engine type is required.")
    private EngineType engine;

    @NotNull(message = "Please select transmission type")
    private TransmissionType transmission;

    @Min(value = 1900,message = "You have entered invalid year.")
    @Max(value = 2099,message = "You have entered invalid year.")
    private Integer year;

    @Min(value = 0,message = "Mileage should be positive number.")
    @Max(900000)
    private Integer mileage;

    @NotBlank(message = "You need to add some description")
    private String description;


    public OfferDto() {
    }

    public ModelDto getModelDto() {
        return modelDto;
    }

    public void setModelDto(ModelDto modelDto) {
        this.modelDto = modelDto;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
