package bg.softuni.personalproject.web;

import bg.softuni.personalproject.model.dto.CategoryDTO;
import bg.softuni.personalproject.model.view.CategoryViewModel;
import bg.softuni.personalproject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @GetMapping("/")
    public String indexPage(Model model){
        model.addAttribute("firstCategoryItem", getFirstCategory(categoryService.getAllCategories()));
        model.addAttribute("allOtherItems",getOtherCategories(categoryService.getAllCategories()));

        return "index";
    }

    @GetMapping("/contacts")
    public String contactsPage(){
        return "contacts-page";
    }


    private CategoryViewModel getFirstCategory(List<CategoryDTO> categories){
        return categories.stream().map(categoryDTO -> modelMapper.map(categoryDTO, CategoryViewModel.class))
                .collect(Collectors.toList()).get(0);
    }

    private List<CategoryViewModel> getOtherCategories(List<CategoryDTO> categories){
        return categories.stream().skip(1).map(categoryDTO -> modelMapper.map(categoryDTO, CategoryViewModel.class))
                .collect(Collectors.toList());

    }
}
