package bg.softuni.personalproject.web;


import bg.softuni.personalproject.model.dto.CategoryDTO;
import bg.softuni.personalproject.model.dto.UserRegisterDTO;
import bg.softuni.personalproject.service.CategoryService;

import bg.softuni.personalproject.service.OrderService;
import bg.softuni.personalproject.service.ProductService;
import bg.softuni.personalproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public AdminController(CategoryService categoryService, UserService userService, ProductService productService, OrderService orderService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public String adminPage(Model model) {

        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("orders", orderService.getAllOrders());
        return "admin-panel";
    }

    @GetMapping("/category/edit/{id}")
    private String categoryEditPage(@PathVariable("id") Long id, Model model) {
        //ToDo make category View Model
        model.addAttribute("categoryData", categoryService.getCategoryDTO(id));
        return "change-category";
    }

    @PostMapping("/category/edit/{id}")

    private String categoryEditConfirm(@PathVariable("id") Long id, @Valid CategoryDTO categoryDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("categoryDTO", categoryDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.categoryDTO", bindingResult);

            return "redirect:/admin/category/edit/{id}";
        }
        categoryService.changeCategory(categoryDTO, id);
        return "redirect:/admin";
    }

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/admin/categories/all";
    }


    @GetMapping("/category/add")
    public String categoryAddPage(){
        return "add-category";
    }

    @GetMapping("/categories/all")
    public String allCategoriesPage(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category-admin";
    }

    @PostMapping("/category/add")
    public String categoryAddConfirm(@Valid CategoryDTO categoryDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("categoryDTO", categoryDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.categoryDTO", bindingResult);

            return "redirect:/admin/category/add";
        }
        categoryService.addCategory(categoryDTO);
        return "redirect:/admin";
    }


    @GetMapping("/users/all")
    public String allUsersPage(Model model, Principal principal){
        userService.userPurchaseTotal(userService.findByName(principal.getName()));
        model.addAttribute("users", userService.findAll());
        model.addAttribute("userService",userService);
        model.addAttribute("count",userService.findAll().size());
        return "users-admin";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/admin/users/all";
    }

    @GetMapping("/users/record/{id}")
    public String makeUserActive(@PathVariable("id") Long id){
        userService.makeUserActive(id);
        return "redirect:/admin/users/all";
    }


    @ModelAttribute
    public CategoryDTO categoryDTO() {
        return new CategoryDTO();
    }


}
