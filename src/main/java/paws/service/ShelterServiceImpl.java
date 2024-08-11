package paws.service;

import java.util.List;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import paws.domain.Shelter;
import paws.exception.PawsException;
import paws.repository.ShelterRepository;

@Service
@RequiredArgsConstructor
public class ShelterServiceImpl implements ShelterService{

    private final ShelterRepository repository;

    @Override
    public List<Shelter> getAll() {
        return StreamSupport.stream(repository.findByActive(1).spliterator(), false)
                .toList();
    }

    @Override
    public Shelter getShelterById(Long id) throws PawsException {
        return repository.findById(id).orElseThrow(()->new PawsException("Приют не найден"));
    }

    @Override
    public void saveShelter(String name) {
        repository.save(new Shelter(null, name, 1));
    }

    @Override
    public void deleteShelterById(Long id) throws PawsException {
        Shelter shelter = repository.findById(id).orElseThrow(()->new PawsException("Приют не найден"));
        shelter.setActive(0);
        repository.save(shelter);
    }

    @Override
    public void updateShelter(Long id, String name) {
        repository.save(new Shelter(id, name, 1));
    }
}
