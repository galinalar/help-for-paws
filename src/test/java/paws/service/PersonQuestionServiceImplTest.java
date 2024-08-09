package paws.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import paws.domain.*;
import paws.mapper.PersonQuestionMapper;
import paws.repository.PersonQuestionRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {PersonQuestionServiceImpl.class, PersonQuestionMapper.class})
class PersonQuestionServiceImplTest {

    @MockBean
    private PersonQuestionRepository repository;
    @Autowired
    private PersonQuestionService personQuestionService;
    PersonQuestion personQuestion = new PersonQuestion(1L, "1", List.of());
    PersonQuestion personQuestion2 = new PersonQuestion(2L, "2", List.of());


    @Test
    void getAll() {
        when(repository.findAll()).thenReturn(List.of(personQuestion, personQuestion2));
        List<PersonQuestion> questions = personQuestionService.getAll();
        assertEquals(2, questions.size());
        assertEquals(personQuestion, questions.get(0));
        assertEquals(personQuestion2, questions.get(1));
    }
}