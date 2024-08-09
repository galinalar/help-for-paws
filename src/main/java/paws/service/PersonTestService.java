package paws.service;

import paws.domain.Person;
import paws.domain.PersonQuestion;
import paws.dto.PersonTestDto;
import paws.exception.PawsException;

import java.util.List;

public interface PersonTestService {
    List<PersonTestDto> getAll();

    List<PersonQuestion> getPersonTestById(Person person);

    void savePersonTest(Long answerId, Person person) throws PawsException;
}
