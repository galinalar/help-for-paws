package paws.service;

import paws.domain.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAll();

    Person getPersonById(Long id);
}
