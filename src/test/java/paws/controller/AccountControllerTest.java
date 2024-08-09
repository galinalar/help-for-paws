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
import paws.repository.ApplicationUserRepository;
import paws.service.AccountService;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountController.class)
@Import({AccountController.class, AccountService.class})
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    ApplicationUserRepository repository;

    @MockBean
    private AccountService service;
    @Test
    @WithMockUser(username = "admin", password = "admin")
    void registration() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/account/registration"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("registration"));
    }
}