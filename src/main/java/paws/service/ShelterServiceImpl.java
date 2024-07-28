package paws.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import paws.domain.Shelter;
import paws.dto.ShelterDto;
import paws.mapper.ShelterMapper;
import paws.repository.ShelterRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ShelterServiceImpl implements ShelterService{

    private final ShelterRepository repository;

    private final ShelterMapper mapper;

    @Override
    public List<ShelterDto> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::map).toList();
    }

    @Override
    public ShelterDto getShelterById(Long id) {
        return repository.findById(id).map(mapper::map).orElseThrow(RuntimeException::new);
    }
}
