package bg.softuni.personalproject.service;

import bg.softuni.personalproject.exception.ObjectNotFoundException;
import bg.softuni.personalproject.model.dto.CategoryDTO;
import bg.softuni.personalproject.model.entity.CategoryEntity;
import bg.softuni.personalproject.repository.CategoryRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;


import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryServiceTest;

    @Mock
    private CategoryRepository categoryRepository;
    @Spy
    private ModelMapper modelMapper;



    private CategoryEntity categoryOne;

    private CategoryEntity categoryTwo;


    @BeforeEach
    void setUp() {
        modelMapper = new ModelMapper();
        categoryOne = new CategoryEntity();
        categoryOne.setName("CATONE");
        categoryOne.setImageUrl("BLABLA");
        categoryOne.setDeleted(false);
        categoryTwo = new CategoryEntity();
        categoryTwo.setName("CATTWO");
        categoryTwo.setImageUrl("BLABLABLA");
        categoryTwo.setDeleted(false);

    }

    @Test
    void getAllCategories() {

        when(categoryRepository.findAll()).thenReturn(List.of(categoryOne, categoryTwo));
        categoryRepository.save(categoryOne);
        categoryRepository.save(categoryTwo);
        List<CategoryDTO> allCategories = categoryServiceTest.getAllCategories();
        assertThat(allCategories.size()).isEqualTo(2);

    }

    @Test
    void getAllCategoriesThrowsException() {
        Assertions.assertThrows(ObjectNotFoundException.class, () -> {
            categoryServiceTest.getAllCategories();
        });

    }

    @Test
    void getCategoryDTOThrowsException() {
        when(categoryRepository.findById(1l)).thenReturn(Optional.of(categoryOne)).thenReturn(null);
        Assertions.assertThrows(ObjectNotFoundException.class, () -> {
            categoryServiceTest.getCategoryDTO(1L);
        });
    }


    @Test
    void getCategoryDTO() {
        categoryRepository.save(categoryOne);
        when(categoryRepository.findById(1l)).thenReturn(Optional.of(categoryOne));
        CategoryDTO categoryDTO = categoryServiceTest.getCategoryDTO(1L);
        Assert.notNull(categoryDTO);
    }

    @Test
    void changeCategory() {
        CategoryEntity save = categoryRepository.save(categoryOne);
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryServiceTest.changeCategory(categoryDTO, 1L);
     verify(categoryRepository,times(1)).save(any());

    }

    @Test
    void deleteCategory() {
    }

    @Test
    void addCategory() {
    }

    @Test
    void passedCategoryExists() {
    }

    @Test
    void filterDeleteDCategories() {
    }

    @Test
    void findCategoryByName() {
    }
}