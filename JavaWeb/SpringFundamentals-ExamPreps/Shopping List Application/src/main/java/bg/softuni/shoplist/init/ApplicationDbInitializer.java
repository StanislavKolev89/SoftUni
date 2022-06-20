package bg.softuni.shoplist.init;

import bg.softuni.shoplist.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationDbInitializer implements CommandLineRunner {

  private final CategoryService categoryService;

    public ApplicationDbInitializer(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
      categoryService.initCategories();
    }
}
