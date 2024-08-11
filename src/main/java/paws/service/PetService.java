package paws.service;

import java.util.List;
import paws.domain.Pet;
import paws.dto.PetDto;
import paws.exception.PawsException;

public interface PetService {
    List<PetDto> getAll();
    List<Pet> getAllbyShelter(Long id);

    Pet getPetById(Long id) throws PawsException;

    void savePet(String name, Long shelterId) throws PawsException;

    void savePetWithFile(String name, Long shelterId, String path) throws PawsException;

    void updatePetWithFile(Long id, String name, Long shelterId, String path) throws PawsException;

    void updatePet(Long id, String name, Long shelterId) throws PawsException;

    void deletePetById(Long id) throws PawsException;
}
