package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.dto.CategoryDTO;
import bg.softuni.personalproject.model.entity.CategoryEntity;
import bg.softuni.personalproject.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().filter(categoryEntity -> categoryEntity.isDeleted()==false).
        map(categoryEntity -> {
            CategoryDTO dto = modelMapper.map(categoryEntity, CategoryDTO.class);

            return dto;
        }).collect(Collectors.toList());
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
        CategoryEntity categoryEntity = categoryRepository.findById(id).get();
        categoryEntity.setDeleted(true);
        categoryRepository.save(categoryEntity);
    }

    public void addCategory(CategoryDTO categoryDTO) {
         categoryRepository.save(modelMapper.map(categoryDTO, CategoryEntity.class));
    }

}
