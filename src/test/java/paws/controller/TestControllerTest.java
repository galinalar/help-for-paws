package paws.controller;


import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import paws.domain.PersonQuestion;
import paws.service.*;
@ExtendWith(SpringExtension.class)
@WebMvcTest(TestController.class)
@Import({TestController.class, PersonQuestionService.class, PersonTestService.class, PersonService.class})
class TestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PersonQuestionService service;
    @MockBean
    private PersonTestService personTestService;
    @MockBean
    private PersonService personService;

    @Test
    @WithMockUser(username = "admin", password = "admin")
    void getTest() throws Exception {
        List<PersonQuestion> questions = new ArrayList<>();
        when(service.getAll()).thenReturn(questions);

        mockMvc.perform(MockMvcRequestBuilders.get("/test"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("test"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("question_list"));
    }
}