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
import paws.domain.CombinationResult;
import paws.domain.Person;
import paws.domain.Pet;
import paws.repository.CombinationRepository;
import paws.service.CombinationService;
import paws.service.PersonService;
import paws.service.PetService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CombinationController.class)
@Import({CombinationController.class, PersonService.class, PetService.class, CombinationService.class})
class CombinationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    CombinationRepository repository;

    @MockBean
    private CombinationService combinationService;

    @MockBean
    private PersonService service;

    @MockBean
    private PetService petService;
    @Test
    @WithMockUser(username = "admin", password = "admin")
    void checkCombination()  throws Exception {

        when(service.getCurrentUser(any())).thenReturn(new Person());

        when(petService.getPetById(1L)).thenReturn(new Pet());

        when(combinationService.getByAnswers(any(),any())).thenReturn(new CombinationResult());

        mockMvc.perform(MockMvcRequestBuilders.get("/combination/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("combination"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("person", "pet", "result" ));
    }
}