package bg.softuni.personalproject.web;

import bg.softuni.personalproject.model.dto.CategoryDTO;
import bg.softuni.personalproject.model.view.CategoryViewModel;
import bg.softuni.personalproject.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Spy
    private ModelMapper modelMapper;

    @Mock
     private CategoryService mockService;


@Test
    void testHomePage() throws Exception {
    CategoryDTO categoryOne = new CategoryDTO();
    categoryOne.setName("TOOLS");
    categoryOne.setImageUrl("/images/CategoryTools.jpg");
    categoryOne.setDeleted(false);
    categoryOne.setId(1L);

    CategoryDTO categoryTwo = new CategoryDTO();
    categoryTwo.setName("TOOLS");
    categoryTwo.setImageUrl("/images/CategoryTools.jpg");
    categoryTwo.setDeleted(false);
    categoryTwo.setId(2L);
    List<CategoryDTO> categories= new ArrayList<>();
    categories.add(categoryOne);
    categories.add(categoryTwo);
    when(mockService.getAllCategories()).thenReturn((categories));
    mockMvc.perform(get("/")).
            andExpect(status().isOk()).andExpect(view().name("index")).
            andExpect(model().attribute("firstCategoryItem", modelMapper.map(categoryOne,CategoryViewModel.class)));

}

    @Test
    void testContactsPage() throws Exception {
        mockMvc.perform(get("/contacts")).
                andExpect(status().isOk()).andExpect(view().name("contacts-page"));
    }

}