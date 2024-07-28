package paws.service;

import paws.domain.Pet;
import paws.dto.PetDto;

import java.util.List;

public interface PetService {
    List<PetDto> getAll();
    List<PetDto> getAllbyShelter(Long id);

    Pet getPetById(Long id);

    void savePet(String name, Long shelterId);

    void updatePet(Long id, String name, Long shelterId);

    void deletePetById(Long id);
}
