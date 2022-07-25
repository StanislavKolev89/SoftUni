package bg.softuni.personalproject.model.dto;


import lombok.Data;

import javax.validation.constraints.Positive;

@Data
public class QuantityHolderDTO {
    @Positive
    private int quantity;


}
