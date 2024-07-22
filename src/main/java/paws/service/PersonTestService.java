package paws.service;

import paws.domain.PersonQuestion;
import paws.domain.PersonTest;

import java.util.List;

public interface PersonTestService {
    List<PersonTest> getAll();

    PersonTest getPersonTestById(Long id);
}
