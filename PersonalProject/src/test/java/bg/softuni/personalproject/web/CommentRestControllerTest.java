package bg.softuni.personalproject.web;

import bg.softuni.personalproject.config.ApplicationConfig;
import bg.softuni.personalproject.model.dto.CommentDTO;
import bg.softuni.personalproject.repository.CommentRepository;
import bg.softuni.personalproject.service.CommentService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//        (classes = {CommentRestController.class, ApplicationConfig.class})
@AutoConfigureMockMvc
@Sql(scripts = "classpath:web/comments-controller.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class CommentRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private CommentRepository commentRepository;

////    @MockBean
////    private CommentService commentService;
//
//    @Test
//    @WithMockUser(roles = "ADMIN")
////    @Sql(statements = "INSERT INTO comments (id, content, created_at) VALUES (1, 'pra6ki', now())")
//    @Sql(statements = "delete from comments", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//    @Disabled
//
//    void getComments() throws Exception {
////        Mockito.when(commentService.getAllCommentsOfCurrentProduct(1L))
////                .thenReturn(List.of(
////                        CommentDTO.builder()
////                                .id(2L)
////                        .build()));
//
//        mockMvc.perform(get("/api/{productId}/comments", 1)).
//                andExpect(status().isOk());
//    }
}