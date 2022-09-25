package bg.softuni.personalproject.model.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderViewModel {

    private Long id;

    private LocalDateTime createdAt;

    private String user;
}
