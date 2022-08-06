package bg.softuni.personalproject.web;

import bg.softuni.personalproject.model.dto.CategoryDTO;
import bg.softuni.personalproject.model.entity.OrderEntity;
import bg.softuni.personalproject.model.view.CategoryViewModel;
import bg.softuni.personalproject.repository.OrderRepository;
import bg.softuni.personalproject.repository.UserRepository;
import bg.softuni.personalproject.service.*;
import org.apache.catalina.Authenticator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(roles = "ADMIN")
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void adminPage() throws Exception {
        mockMvc.perform(get("/admin")).
                andExpect(status().isOk()).andExpect(view().name("admin-panel"));
    }

    @Test
    void CategoryEditPage() throws Exception {
        CategoryDTO categoryOne = new CategoryDTO();
        categoryOne.setName("TOOLS");
        categoryOne.setImageUrl("/images/CategoryTools.jpg");
        categoryOne.setDeleted(false);
        categoryOne.setId(1L);
        mockMvc.perform(get("/admin/category/edit/{id}", 1)).
                andExpect(model().attributeExists("categoryData")).
                andExpect(status().isOk()).andExpect(view().name("change-category"));

    }

    @Test
    void deleteCategory() throws Exception {
        mockMvc.perform(get("/admin/category/delete/{id}", 1)).
                andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/admin/categories/all"));
    }

    @Test
    void categoryAddPage() throws Exception {
        mockMvc.perform(get("/admin/categories/add")).
                andExpect(status().isOk()).andExpect(view().name("add-category"));
    }

    @Test
    void allCategoriesPage() throws Exception {
        mockMvc.perform(get("/admin/categories/all")).
                andExpect(status().isOk()).andExpect(view().name("category-admin"));
    }

    @Test
    void categoryAddConfirm() throws Exception {
        mockMvc.perform(post("/admin/categories/add").
                        param("id", "1").
                        param("name", "TOOLS").
                        param("imageUrl", "ASDASDASDASDASD").
                        param("deleted", "false").
                        with(csrf())).andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("/admin/categories/all"));
    }

    @Test
    void categoryAddConfirmHasErrors() throws Exception {
        mockMvc.perform(post("/admin/categories/add").
                        param("id", "1").
                        param("name", "TO").
                        param("imageUrl", "ASDASDASDASDASD").
                        param("deleted", "false").
                        with(csrf())).andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("/admin/categories/add"));
    }


    @Test
    void makeUserNotActive() throws Exception {
        mockMvc.perform(get("/admin/users/deactivate/{id}", 1L)).
                andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/admin/users/all"));
    }

    @Test
    void makeUserActive() throws Exception {
        mockMvc.perform(get("/admin/users/activate/{id}", 1L)).
                andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/admin/users/all"));


    }

    @Test
    void giveUserAdminRights() throws Exception {
        mockMvc.perform(get("/admin/users/makeAdmin/{id}", 1L)).
                andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/admin/users/all"));
    }

    @Test
    void removeUserAdminRights() throws Exception {
        mockMvc.perform(get("/admin/users/removeAdmin/{id}", 1L)).
                andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/admin/users/all"));
    }

    @Test
    void deleteUser() throws Exception {
        mockMvc.perform(get("/admin/users/delete/{id}", 1L)).
                andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/admin/users/all"));

    }

    @Test
    void deleteOrder() throws Exception {

        mockMvc.perform(get("/admin/orders/delete/{id}", 1L)).
                andExpect(status().isOk()).andExpect(view().name("orders-admin"));
    }

    @Test
    void orderDetails() throws Exception {
        mockMvc.perform(get("/admin/orders/details/{id}", 1)).
                andExpect(model().attributeExists("allProductsInOrder")).
                andExpect(model().attributeExists("service")).
                andExpect(status().isOk()).andExpect(view().name("order-products-details"));
    }

    @Test
    void allProductsPage() throws Exception {
        mockMvc.perform(get("/admin/products/all", 1)).
                andExpect(model().attributeExists("products")).
                andExpect(model().attributeExists("count")).
                andExpect(status().isOk()).andExpect(view().name("products-admin"));
    }

    @Test
    void editProductPage() throws Exception {
        mockMvc.perform(get("/admin/products/edit/{id}", 1)).
                andExpect(model().attributeExists("productData")).
                andExpect(model().attributeExists("categories")).
                andExpect(status().isOk()).andExpect(view().name("edit-product"));


    }

    @Test
    void editProductConfirm() throws Exception {
        mockMvc.perform(post("/admin/products/edit/{id}", 1).with(csrf()).
                        param("title", "TITLE").
                        param("description", "DESCRIPTIONDESCRIPTION").
                        param("price", "20").
                        param("imageUrl", "idasdasdasdasd").
                        param("category", "TOOLS")).
                andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/admin/products/all"));

    }

    @Test
    void editProductConfirmRedirectError() throws Exception {
        mockMvc.perform(post("/admin/products/edit/{id}", 1).with(csrf()).
                        param("title", "TITLE").
                        param("description", "DESCRITION").
                        param("price", "20").
                        param("imageUrl", "idasdasdasdasd").
                        param("category", "CATEGORY")).
                andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("/admin/products/edit/1"));

    }


    @Test
    void deleteProduct() throws Exception {
        mockMvc.perform(get("/admin/products/delete/{id}", 1L)).
                andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/admin/products/all"));
    }

    @Test
    void addProductPage() throws Exception {
        mockMvc.perform(get("/admin/products/add")).
                andExpect(model().attributeExists("categories")).
                andExpect(status().isOk()).andExpect(view().name("add-new-product"));
    }

    @Test
    void addProductConfirm() throws Exception {
        mockMvc.perform(post("/admin/products/add").with(csrf()).
                        param("title", "TITLE").
                        param("description", "DESCRI").
                        param("price", "20").
                        param("imageUrl", "idasdasdasdasd").
                        param("category", "TOOLS")).
                andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("/admin/products/add"));
    }


    @Test
    void addProductConfirmRedirectError() throws Exception {
        mockMvc.perform(post("/admin/products/add").with(csrf()).
                        param("title", "TITLE").
                        param("description", "DESCRITIONasdasdasd").
                        param("price", "20").
                        param("imageUrl", "idasdasdasdasd").
                        param("category", "TOOLS")).
                andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("/admin/products/all"));
    }

    @Test
    void categoryDTO() {
    }

    @Test
    void productDTO() {
    }

}