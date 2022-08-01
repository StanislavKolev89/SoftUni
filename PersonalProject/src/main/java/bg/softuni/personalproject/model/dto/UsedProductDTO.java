package bg.softuni.personalproject.model.dto;


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


public class UsedProductDTO {

    private Long id;

    @Size(min=5)
    private String title;

    @NotBlank
    @Size(min=10)
    private String description;

    @Positive
    private BigDecimal price;

    @NotBlank
    private String phoneNumber;

    private String imageUrl;

    @NotNull
    private String category;

    private String user;
}
