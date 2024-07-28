package paws.service;

import paws.domain.Person;
import paws.domain.PersonQuestion;
import paws.dto.PersonQuestionDto;

import java.util.List;

public interface PersonQuestionService {
    List<PersonQuestion> getAll();

    PersonQuestionDto getPersonQuestionById(Long id);
}
