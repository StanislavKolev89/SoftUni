package bg.softuni.personalproject.model.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
public class QuantityHolderDTO {
    @Positive
    private int quantity;


}
