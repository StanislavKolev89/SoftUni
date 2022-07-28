package bg.softuni.personalproject.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsedProductDTO {

    private Long id;

    private String title;

    private String description;

    private BigDecimal price;

    private String phoneNumber;

    private String imageUrl;

    private String category;

    private String user;
}
