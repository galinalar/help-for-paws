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
import paws.domain.Pet;
import paws.domain.Shelter;
import paws.repository.PetRepository;
import paws.service.PetService;
import paws.service.ShelterService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PetController.class)
@Import({PetController.class, PetService.class, ShelterService.class})
class PetControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    PetRepository repository;
    @MockBean
    private PetService petService;
    @MockBean
    private ShelterService shelterService;
    @Test
    @WithMockUser(username = "admin", password = "admin")
    void getPetsbyShelter() throws Exception {
        List<Pet> pets = new ArrayList<>();
        when(petService.getAllbyShelter(1L)).thenReturn(pets);

        mockMvc.perform(MockMvcRequestBuilders.get("/pets/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("pets"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("pet_list", "shelter"));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin")
    void createPet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pets/create/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("new_pet"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("id"));
    }
    @Test
    @WithMockUser(username = "admin", password = "admin")
    void editPet() throws Exception {
        when(petService.getPetById(1L)).thenReturn(new Pet(1L, "name", "", new Shelter(1L, "name", 1),1));
        when(shelterService.getAll()).thenReturn(List.of(new Shelter()));

        mockMvc.perform(MockMvcRequestBuilders.get("/pets/edit/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("edit_pet"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("id", "petName", "shelterID", "shelter_list"));

    }
}