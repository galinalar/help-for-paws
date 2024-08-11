package paws.controller;

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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import paws.domain.Person;
import paws.dto.PersonDto;
import paws.repository.PersonRepository;
import paws.service.AccountService;
import paws.service.PersonService;
@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonController.class)
@Import({PersonController.class, PersonService.class, AccountService.class})
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    PersonRepository repository;

    @MockBean
    private AccountService accountService;

    @MockBean
    private PersonService service;
    @Test
    @WithMockUser(username = "admin", password = "admin")
    void getCurrentPerson()  throws Exception {

        when(service.getCurrentUser(any())).thenReturn(new Person());

        mockMvc.perform(MockMvcRequestBuilders.get("/persons"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("person"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("person"));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin")
    void createPerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/persons/create"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("new_person"));

    }

    @Test
    @WithMockUser(username = "admin", password = "admin")
    void editPerson()  throws Exception {

        when(service.getPersonById(1L)).thenReturn(new PersonDto(1L, "name"));

        mockMvc.perform(MockMvcRequestBuilders.get("/persons/edit/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("edit_person"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("id", "name"));
    }
}