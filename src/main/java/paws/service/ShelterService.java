package paws.service;

import java.util.List;

import paws.domain.Shelter;
import paws.exception.PawsException;

public interface ShelterService {
    List<Shelter> getAll();

    Shelter getShelterById(Long id) throws PawsException;

    void saveShelter(String name);

    void deleteShelterById(Long id) throws PawsException;

    void updateShelter(Long id, String name);

}
