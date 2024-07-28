package paws.service;

import paws.domain.Person;
import paws.domain.Shelter;
import paws.dto.ShelterDto;

import java.util.List;

public interface ShelterService {
    List<ShelterDto> getAll();

    ShelterDto getShelterById(Long id);

}
