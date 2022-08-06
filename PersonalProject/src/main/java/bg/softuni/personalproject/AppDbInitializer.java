package bg.softuni.personalproject;

import bg.softuni.personalproject.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AppDbInitializer implements CommandLineRunner {

    private final RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        roleService.initRoles();
    }
}
