package bg.softuni.personalproject.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuantityHolderDTO {
    @Positive
    private int quantity;


}
