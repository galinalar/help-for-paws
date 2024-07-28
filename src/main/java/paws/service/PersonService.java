package paws.service;

import paws.domain.Person;
import paws.dto.PersonDto;

import java.util.List;

public interface PersonService {
    List<PersonDto> getAll();

    PersonDto getPersonById(Long id);
    Person getCurrentUser(String name);

    Person savePerson(Person person);
}
