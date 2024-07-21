package paws.service;

import paws.domain.Pet;

import java.util.List;

public interface PetService {
    List<Pet> getAll();

    Pet getPetById(Long id);

    void savePet(String name, Long shelterId);

    void updatePet(Long id, String name, Long shelterId);

    void deletePetById(Long id);
}
