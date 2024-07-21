package paws.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import paws.domain.Shelter;
import paws.repository.ShelterRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ShelterServiceImpl implements ShelterService{

    private final ShelterRepository repository;

    @Override
    public List<Shelter> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .toList();
    }

    @Override
    public Shelter getShelterById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }
}
