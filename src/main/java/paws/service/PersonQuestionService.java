package paws.service;

import paws.domain.Person;
import paws.domain.PersonQuestion;

import java.util.List;

public interface PersonQuestionService {
    List<PersonQuestion> getAll();

    PersonQuestion getPersonById(Long id);
}
