package bg.softuni.personalproject.web;
import bg.softuni.personalproject.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WithMockUser(roles = "ADMIN")
@AutoConfigureMockMvc
class CommentRestControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @Test
    void getComments() throws Exception {
        mockMvc.perform(get("/api/{productId}/comments", 1)).
                andExpect(status().isOk());
    }


    @Test
    void getCommentsThrowsCommentNotFoundException() throws Exception {
        mockMvc.perform(get("/api/{productId}/comments", 2)).
                andExpect(status().isNotFound());
    }

//    @Test
//    @WithMockUser(roles = "ADMIN")
//    void createNewComment() throws Exception {
//
//        mockMvc.perform(post("/api/{productId}/comments", 1).with(csrf()).
//                        contentType("application/json").accept("application/json").
//                param("content","content").param("commentCreator","Creator")).
//                andExpect(status().is(201));
//    }
}