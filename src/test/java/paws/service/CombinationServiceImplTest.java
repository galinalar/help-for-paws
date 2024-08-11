package paws.service;


import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import paws.domain.*;
import paws.exception.PawsException;
import paws.repository.CombinationRepository;
import paws.repository.PersonTestRepository;
import paws.repository.PetTestRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {CombinationServiceImpl.class})
class CombinationServiceImplTest {

    @MockBean
    private PersonTestRepository personTestRepository;
    @MockBean
    private PetTestRepository petTestRepository;
    @MockBean
    private CombinationRepository combinationRepository;
    @Autowired
    private CombinationService service;

    @Test
    void getByAnswers() throws PawsException {
        Person person = new Person(1L, "name",1);
        Pet pet = new Pet(1L, "petname", null, null, 1);
        PersonAnswer personAnswer = new PersonAnswer(1L, "1", null);
        PetAnswer petAnswer = new PetAnswer(1L, "1", null);
        PersonAnswer personAnswer2 = new PersonAnswer(2L, "2", null);
        PetAnswer petAnswer2 = new PetAnswer(2L, "2", null);
        when(personTestRepository.findAnswersByPerson(person)).thenReturn(List.of(personAnswer, personAnswer2));
        when(petTestRepository.findAnswersByPet(pet)).thenReturn(List.of(petAnswer, petAnswer2));
        when(combinationRepository.findResultByPetAnswerAndPersonAnswer(personAnswer, petAnswer)).thenReturn(Optional.of(1));
        when(combinationRepository.findResultByPetAnswerAndPersonAnswer(personAnswer, petAnswer2)).thenReturn(Optional.of(0));
        when(combinationRepository.findResultByPetAnswerAndPersonAnswer(personAnswer2, petAnswer2)).thenReturn(Optional.of(1));
        when(combinationRepository.findResultByPetAnswerAndPersonAnswer(personAnswer2, petAnswer)).thenReturn(Optional.of(-1));
        CombinationResult result = service.getByAnswers(person, pet);
        assertEquals(1, result.getResult());
        assertEquals(person, result.getPerson());
        assertEquals(pet, result.getPet());
    }
}