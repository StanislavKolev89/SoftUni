package bg.softuni.personalproject.service;

import bg.softuni.personalproject.exception.ObjectNotFoundException;
import bg.softuni.personalproject.model.dto.CategoryDTO;
import bg.softuni.personalproject.model.entity.CategoryEntity;
import bg.softuni.personalproject.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categoryDTOS = categoryRepository.findAll().stream().
                map(categoryEntity -> {
                    CategoryDTO dto = modelMapper.map(categoryEntity, CategoryDTO.class);

                    return dto;
                }).collect(Collectors.toList());
        if(categoryDTOS.isEmpty()){
            throw new ObjectNotFoundException();
        }
        return categoryDTOS;
    }

    public CategoryDTO  getCategoryDTO(Long id) {
        Optional<CategoryEntity> categoryEntity = categoryRepository.findById(id);
        if(categoryEntity==null){
            throw new ObjectNotFoundException();
        }
        CategoryDTO categoryDTO = modelMapper.map(categoryEntity, CategoryDTO.class);
        return categoryDTO;
    }

    public void changeCategory(CategoryDTO categoryDto, Long productId) {
        CategoryEntity categoryEntity = categoryRepository.findById(productId).orElseThrow(()->new ObjectNotFoundException());
        categoryEntity.setName(categoryDto.getName().toUpperCase(Locale.ROOT));
        categoryEntity.setImageUrl(categoryDto.getImageUrl());
        categoryRepository.save(categoryEntity);
    }

    public void deleteCategory(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow(()->new ObjectNotFoundException());
        categoryEntity.setDeleted(true);
        categoryRepository.save(categoryEntity);
    }

    public void addCategory(CategoryDTO categoryDTO) {
      CategoryEntity category= categoryRepository.findByName(categoryDTO.getName()).get();
        if(category!=null){
            category.setImageUrl(categoryDTO.getImageUrl());
            category.setDeleted(false);
        }
         categoryRepository.save(modelMapper.map(categoryDTO, CategoryEntity.class));
    }

    public boolean passedCategoryExists(String category) {

        return categoryRepository.existsByName(category);
    }


    public List<CategoryDTO> filterDeleteDCategories() {
       return getAllCategories().stream().filter(categoryDTO -> categoryDTO.isDeleted()==false)
                .collect(Collectors.toList());
    }

    public CategoryEntity findCategoryByName(String name) {
     return categoryRepository.findByName(name).get();
    }
}
