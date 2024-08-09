package paws.service;

import paws.domain.Person;
import paws.dto.PersonDto;
import paws.exception.PawsException;

public interface PersonService {

    PersonDto getPersonById(Long id) throws PawsException;
    Person getCurrentUser(String name) throws PawsException;

    Person savePerson(Person person);

    void updatePerson(Long id, String name);
}
