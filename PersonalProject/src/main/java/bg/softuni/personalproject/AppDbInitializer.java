package bg.softuni.personalproject;


import bg.softuni.personalproject.model.entity.OrderEntity;
import bg.softuni.personalproject.model.entity.OrderProductEntity;
import bg.softuni.personalproject.model.entity.ProductEntity;
import bg.softuni.personalproject.model.entity.UserEntity;
import bg.softuni.personalproject.repository.OrderProductRepository;
import bg.softuni.personalproject.service.CategoryService;
import bg.softuni.personalproject.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppDbInitializer implements CommandLineRunner {

    private final RoleService roleService;
    private final CategoryService categoryService;


    public AppDbInitializer(RoleService roleService, CategoryService categoryService) {
        this.roleService = roleService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        roleService.initRoles();
        categoryService.initCategories();

    }
}
