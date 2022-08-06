package bg.softuni.personalproject.web;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.security.Principal;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRegistrationPage() throws Exception {
        mockMvc.perform(get("/users/register")).
                andExpect(status().isOk()).andExpect(view().name("register"));
    }


    @Test
    void testUserRegistration() throws Exception {
        mockMvc.perform(post("/users/register").
                        param("email", "admain@gmail.com").
                        param("firstName", "Admin").
                        param("lastName", "Adminsov").
                        param("username", "Adminscho").
                        param("address", "ADMIN ADMIN STR 1").
                        param("password", "12345").
                        param("confirmPassword", "12345").
                        with(csrf())).andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("/"));
    }

    @Test
    @WithAnonymousUser
    void testProfilePage_withAnonymousUser_Forbidden() throws Exception {
        mockMvc.perform(get("/users/profile")).
                andExpect(status().is3xxRedirection()).
                andExpect(redirectedUrl("http://localhost/users/login"));
    }

    @Test
    @WithMockUser(username = "admin@gmail.com")
    void testUserEditProfile() throws Exception {

        mockMvc.perform(get("/users/profile")).
                      andExpect(status().isOk()).
        andExpect(view().name("profile"));

    }


}
