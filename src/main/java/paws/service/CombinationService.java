package paws.service;

import paws.domain.Combination;
import paws.domain.CombinationResult;
import paws.domain.Person;
import paws.domain.Pet;
import paws.dto.PersonDto;

import java.util.List;

public interface CombinationService {
    CombinationResult getByAnswers(Person person, Pet pet);
}
