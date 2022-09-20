package com.example.springdatamappingexercise.model.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class GameAddDto {
    @Pattern(regexp = "^[A-Z][a-z]{2,99}$")
    private String title;
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;
    @Min(value = 0)
    private Double size;
    @Pattern(regexp = "\\w{11}")
    private String trailer;
    @Pattern(regexp = "^https?:\\/\\/(?!.*:\\/\\/)\\S+")
    private String thumbUrl;
    @Size(min=20)
    private String description;
    private LocalDate releaseDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public GameAddDto(String title, BigDecimal price, Double size, String trailer, String thumbUrl, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thumbUrl = thumbUrl;
        this.description = description;
        this.releaseDate = releaseDate;
    }
}
