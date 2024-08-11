package paws.service;

import java.util.List;
import paws.domain.Person;
import paws.domain.PersonQuestion;
import paws.dto.PersonTestDto;
import paws.exception.PawsException;

public interface PersonTestService {
    List<PersonTestDto> getAll();

    List<PersonQuestion> getPersonTestById(Person person);

    void savePersonTest(Long answerId, Person person) throws PawsException;
}
