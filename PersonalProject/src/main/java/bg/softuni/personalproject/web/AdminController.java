package bg.softuni.personalproject.web;


import bg.softuni.personalproject.model.dto.CategoryDTO;
import bg.softuni.personalproject.model.dto.ProductDTO;
import bg.softuni.personalproject.service.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;
    private final ModelMapper modelMapper;
    private final OrderProductService orderProductService;

    @GetMapping
    public String adminPage(Model model) {
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
    public String categoryAddPage() {
        return "add-category";
    }

    @GetMapping("/categories/all")
    public String allCategoriesPage(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category-admin";
    }

    @PostMapping("/category/add")
    public String categoryAddConfirm(@Valid CategoryDTO categoryDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("categoryDTO", categoryDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.categoryDTO", bindingResult);

            return "redirect:/admin/category/add";
        }
        categoryService.addCategory(categoryDTO);
        return "redirect:/admin";
    }


    @GetMapping("/users/all")
    public String allUsersPage(Model model, Principal principal) {
        userService.userPurchaseTotal(userService.findByName(principal.getName()));
        model.addAttribute("users", userService.findAll());
        model.addAttribute("userService", userService);
        model.addAttribute("count", userService.findAll().size());
        return "users-admin";
    }

    @GetMapping("/users/deactivate/{id}")
    public String makeUserNotActive(@PathVariable("id") Long id) {
        userService.makeUserNotActive(id);
        return "redirect:/admin/users/all";
    }

    @GetMapping("/users/activate/{id}")
    public String makeUserActive(@PathVariable("id") Long id) {
        userService.makeUserActive(id);
        return "redirect:/admin/users/all";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users/all";
    }


    @GetMapping("/orders/all")
    public String allOrdersPage(Model model) {
        model.addAttribute("allOrders", orderService.getAllOrders());
        model.addAttribute("count", orderService.getAllOrders().size());
        model.addAttribute("orderService", orderService);
        model.addAttribute("totalTurnover", orderProductService.findTurnover());
        return "orders-admin";
    }

    @GetMapping("/orders/delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return "redirect:/admin/orders/all";
    }

    @GetMapping("/orders/details/{id}")
    public String orderDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("allProductsInOrder", orderProductService.findAllOrderProducts(id));
        model.addAttribute("service", orderProductService);

        return "order-products-details";
    }


    @GetMapping("/products/all")
    public String allProductsPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("count", productService.getAllProducts().size());
        return "products-admin";
    }

    @GetMapping("/products/edit/{id}")
    private String editProduct(@PathVariable("id") Long id,Model model){
        model.addAttribute("productData",productService.getViewModel(id));
        model.addAttribute("categories", categoryService.getAllCategories());
    return "change-product";
    }

//    @GetMapping("/products/edit/{id}")
//    private String editProductConfirm(@PathVariable("id") Long id, @Valid CategoryDTO categoryDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
//
//    }

    @ModelAttribute
    public CategoryDTO categoryDTO() {
        return new CategoryDTO();
    }

    @ModelAttribute
    public ProductDTO productDTO(){
        return new ProductDTO();
    }
}
