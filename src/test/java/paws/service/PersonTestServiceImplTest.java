package paws.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import paws.domain.Person;
import paws.domain.PersonAnswer;
import paws.domain.PersonQuestion;
import paws.domain.PersonTest;
import paws.dto.PersonTestDto;
import paws.exception.PawsException;
import paws.mapper.PersonTestMapper;
import paws.mapper.PersonTestMapperImpl;
import paws.repository.PersonAnswerRepository;
import paws.repository.PersonQuestionRepository;
import paws.repository.PersonTestRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {PersonTestServiceImpl.class, PersonTestMapperImpl.class})
class PersonTestServiceImplTest {
    @MockBean
    private PersonTestRepository repository;
    @MockBean
    private PersonAnswerRepository personAnswerRepository;
    @MockBean
    private PersonQuestionRepository personQuestionRepository;
    @Autowired
    private PersonTestMapper mapper;
    @Autowired
    private PersonTestService personTestService;
    Person person = new Person(1L, "name", 1);
    PersonAnswer personAnswer = new PersonAnswer(1L, "a", null);
    PersonQuestion personQuestion = new PersonQuestion(1L, "q", List.of(personAnswer));
    PersonTest personTest = new PersonTest(1L, new Date(), personAnswer, person);
    @Test
    void getAll() {
        when(repository.findAll()).thenReturn(List.of(personTest));
        List<PersonTestDto> personTestDtos = personTestService.getAll();
        assertEquals(List.of(mapper.map(personTest)), personTestDtos);
    }

    @Test
    void getPersonTestById() {
        when(repository.findAnswersByPerson(person)).thenReturn(List.of(personAnswer));
        when(personQuestionRepository.findAll()).thenReturn(List.of(personQuestion));
        List<PersonQuestion> personQuestions = personTestService.getPersonTestById(person);
        assertEquals(List.of(personQuestion), personQuestions);
    }

    @Test
    void savePersonTest() throws PawsException {
        when(personAnswerRepository.findById(1L)).thenReturn(Optional.ofNullable(personAnswer));
        personTestService.savePersonTest(1L, person);

        ArgumentCaptor<PersonTest> captor = ArgumentCaptor.forClass(PersonTest.class);
        verify(repository, times(1)).save(captor.capture());
        assertEquals(person, captor.getValue().getPerson());
        assertEquals(personAnswer, captor.getValue().getAnswer());
    }
}