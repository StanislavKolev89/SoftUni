package bg.softuni.personalproject.model.view;

import bg.softuni.personalproject.model.entity.CategoryEntity;
import lombok.AllArgsConstructor;
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
public class ProductViewModel {
    @Positive
    private Long id;

    @NotBlank
    @Size(min=5)
    private String title;

    @NotBlank
    @Size(min=15)
    private String description;

    @Positive
    private BigDecimal price;

    @NotBlank
    private String imageUrl;

    @NotNull
    private CategoryEntity category;
}
