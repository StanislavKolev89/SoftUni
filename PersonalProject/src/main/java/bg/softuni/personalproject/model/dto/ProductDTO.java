package bg.softuni.personalproject.model.dto;

import bg.softuni.personalproject.model.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private Long id;

    @NotBlank
    @Size(min=5,message = "Title is too short!")
    private String title;

    @NotBlank
    @Size(min=15,message = "Description is too short!")
    private String description;

    @Positive(message="Value must be positive number!")
    private BigDecimal price;

    @NotBlank
    private String imageUrl;

    @NotNull
    private String category;

}
