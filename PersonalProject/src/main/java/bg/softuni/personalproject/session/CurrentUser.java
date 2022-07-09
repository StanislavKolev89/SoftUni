package bg.softuni.personalproject.session;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Data
public class CurrentUser {
    private Long id;
    private String email;
}
