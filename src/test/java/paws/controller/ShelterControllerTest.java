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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import paws.domain.Shelter;
import paws.repository.ShelterRepository;
import paws.service.ShelterService;
import paws.service.ShelterServiceImpl;
@ExtendWith(SpringExtension.class)
@WebMvcTest(ShelterController.class)
@Import({ShelterController.class, ShelterServiceImpl.class})
class ShelterControllerTest {
    Shelter shelter1 = new Shelter(1L, "shelter1", 1);

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    ShelterRepository repository;

    @MockBean
    private ShelterService shelterService;
    @Test
    @WithMockUser(username = "admin", password = "admin")
    public void test_auth() throws Exception {
        mockMvc.perform(get("/shelters"))
                .andExpect(status().isOk());
    }
    @Test
    public void test_unauth() throws Exception {
        mockMvc.perform(get("/shelters"))
                .andExpect(status().isUnauthorized());
    }
    @Test
    @WithMockUser(username = "admin", password = "admin")
    void getShelters() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/shelters"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("shelters"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("shelter_list"));

    }

    @Test
    @WithMockUser(username = "admin", password = "admin")
    void createShelter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/shelters/create"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("new_shelter"));

    }
    @Test
    @WithMockUser(username = "admin", password = "admin")
    void editShelter() throws Exception {
        when(shelterService.getShelterById(1L)).thenReturn(shelter1);

        mockMvc.perform(MockMvcRequestBuilders.get("/shelters/edit/"+1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("edit_shelter"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("id", "shelterName"));
    }
}