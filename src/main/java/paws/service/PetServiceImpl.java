package paws.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import paws.domain.Person;
import paws.domain.Pet;
import paws.domain.Shelter;
import paws.dto.PetDto;
import paws.dto.ShelterDto;
import paws.mapper.PersonMapper;
import paws.mapper.PetMapper;
import paws.repository.PetRepository;

import java.util.List;
import java.util.stream.StreamSupport;

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
    public List<PetDto> getAllbyShelter(Long id) {
        return StreamSupport.stream(repository.findByShelterId(id).spliterator(), false)
                .map(mapper::map).toList();
    }

    @Override
    public Pet getPetById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void savePet(String name, Long shelterId) {
//        ShelterDto shelter = shelterService.getShelterById(shelterId);
//        Pet pet = new Pet(null, name, shelter);
//        repository.save(pet);
    }

    @Override
    public void updatePet(Long id, String name, Long shelterId) {
//        Shelter shelter = shelterService.getShelterById(shelterId);
//        Pet pet = new Pet(id, name, shelter);
//        repository.save(pet);

    }

    @Override
    public void deletePetById(Long id) {
        Pet pet = repository.findById(id).orElseThrow(RuntimeException::new);
        repository.delete(pet);
    }

}
