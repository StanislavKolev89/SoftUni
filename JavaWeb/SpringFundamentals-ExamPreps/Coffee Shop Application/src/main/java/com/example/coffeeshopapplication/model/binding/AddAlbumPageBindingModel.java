package com.example.coffeeshopapplication.model.binding;

import com.example.coffeeshopapplication.model.enums.CategoryEnum;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AddAlbumPageBindingModel {
    @NotBlank
    @Size(min=3,max=20)
    private String name;
    @NotNull
    @Positive
    private BigDecimal price;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime orderTime;

    @NotNull
    private CategoryEnum category;

    @NotBlank
    @Size(min=5)
    private String description;
}
