package paws.service;

import paws.domain.Person;
import paws.domain.Shelter;

import java.util.List;

public interface ShelterService {
    List<Shelter> getAll();

    Shelter getShelterById(Long id);

}
