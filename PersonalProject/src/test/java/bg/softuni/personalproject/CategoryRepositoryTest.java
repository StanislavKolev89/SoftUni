package bg.softuni.personalproject;

import bg.softuni.personalproject.model.entity.CategoryEntity;
import bg.softuni.personalproject.repository.CategoryRepository;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void categoriesInserted() {
        List<CategoryEntity> categories = categoryRepository.findAll();

        Assertions.assertEquals(5, categories.size());
    }
}
