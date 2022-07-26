package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.dto.CategoryDTO;
import bg.softuni.personalproject.model.entity.CategoryEntity;
import bg.softuni.personalproject.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;


    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }


    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    public CategoryEntity findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public CategoryDTO getCategoryDTO(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).get();
        //ToDo Check why model mapper cannot map all fields
        CategoryDTO categoryDTO = modelMapper.map(categoryEntity, CategoryDTO.class);
        return categoryDTO;
    }

    public void changeCategory(CategoryDTO categoryDto, Long productId) {
        CategoryEntity categoryEntity = categoryRepository.findById(productId).get();
        categoryEntity.setName(categoryDto.getName().toUpperCase(Locale.ROOT));
        categoryEntity.setImageUrl(categoryDto.getImageUrl());
        categoryRepository.save(categoryEntity);

    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public void addCategory(CategoryDTO categoryDTO) {
         categoryRepository.save(modelMapper.map(categoryDTO, CategoryEntity.class));
    }
}
