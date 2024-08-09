package paws.service;

import paws.domain.Shelter;
import paws.exception.PawsException;

import java.util.List;

public interface ShelterService {
    List<Shelter> getAll();

    Shelter getShelterById(Long id) throws PawsException;

    void saveShelter(String name);

    void deleteShelterById(Long id) throws PawsException;

    void updateShelter(Long id, String name);

}
