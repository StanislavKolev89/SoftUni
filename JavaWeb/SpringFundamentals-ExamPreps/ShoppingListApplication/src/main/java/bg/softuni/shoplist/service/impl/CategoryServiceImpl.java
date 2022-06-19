package bg.softuni.shoplist.service.impl;

import bg.softuni.shoplist.model.Entity.CategoryEntity;
import bg.softuni.shoplist.model.Entity.CategoryEnum;
import bg.softuni.shoplist.repository.CategoryRepository;
import bg.softuni.shoplist.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if(categoryRepository.count()>0){
            return;
        }
        Arrays.stream(CategoryEnum.values()).forEach(categoryEnum -> {
            CategoryEntity categoryEntity = new CategoryEntity();
            categoryEntity.setName(categoryEnum);
            categoryRepository.save(categoryEntity);
        });
    }
}
