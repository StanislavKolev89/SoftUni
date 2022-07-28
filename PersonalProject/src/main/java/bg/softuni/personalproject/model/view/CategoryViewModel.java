package bg.softuni.personalproject.model.view;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryViewModel {

    private Long id;

    private String name;


    private String imageUrl;
}
