package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.model.CategoryEntity;
import bg.softuni.personalproject.model.enums.CategoryEnum;
import bg.softuni.personalproject.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void initCategories() {
        Arrays.stream(CategoryEnum.values()).forEach(categoryEnum -> {
            categoryRepository.save(new CategoryEntity().name(categoryEnum));
        });
    }


    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }


}
