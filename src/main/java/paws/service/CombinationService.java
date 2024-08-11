package paws.service;

import paws.domain.CombinationResult;
import paws.domain.Person;
import paws.domain.Pet;
import paws.exception.PawsException;

public interface CombinationService {
    CombinationResult getByAnswers(Person person, Pet pet) throws PawsException;
}
