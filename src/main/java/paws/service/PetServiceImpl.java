package paws.service;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import paws.domain.Pet;
import paws.domain.Shelter;
import paws.dto.PetDto;
import paws.exception.PawsException;
import paws.mapper.PetMapper;
import paws.repository.PetRepository;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService{
    private final PetRepository repository;
    private final ShelterService shelterService;
    private final PetMapper mapper;
    @Override
    public List<PetDto> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::map).toList();
    }

    @Override
    public List<Pet> getAllbyShelter(Long id) {
        return StreamSupport.stream(repository.findByShelterIdAndActive(id, 1).spliterator(), false)
                .toList();
    }

    @Override
    public Pet getPetById(Long id) throws PawsException {
        return repository.findById(id).orElseThrow(()->new PawsException("Питомец не найден"));
    }

    @Override
    public void savePet(String name, Long shelterId) throws PawsException {
        Shelter shelter = shelterService.getShelterById(shelterId);
        Pet pet = new Pet(null, name, null, shelter, 1);
        repository.save(pet);
    }

    @Override
    public void savePetWithFile(String name, Long shelterId, String path) throws PawsException {
        Shelter shelter = shelterService.getShelterById(shelterId);
        Pet pet = new Pet(null, name, path, shelter, 1);
        repository.save(pet);
    }

    @Override
    public void updatePetWithFile(Long id, String name, Long shelterId, String path) throws PawsException {

        Shelter shelter = shelterService.getShelterById(shelterId);
        Pet pet = new Pet(id, name, path, shelter, 1);
        repository.save(pet);
    }

    @Override
    public void updatePet(Long id, String name, Long shelterId) throws PawsException {
        Shelter shelter = shelterService.getShelterById(shelterId);
        Pet petOld = repository.findById(id).orElseThrow(()->new PawsException("Питомец не найден"));
        Pet pet = new Pet(id, name, petOld.getPath(), shelter, 1);
        repository.save(pet);

    }

    @Override
    public void deletePetById(Long id) throws PawsException {
        Pet pet = repository.findById(id).orElseThrow(()->new PawsException("Питомец не найден"));
        pet.setActive(0);
        repository.save(pet);
    }

}
