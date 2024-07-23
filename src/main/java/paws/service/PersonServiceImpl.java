package paws.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import paws.domain.Person;
import paws.dto.PersonDto;
import paws.mapper.PersonMapper;
import paws.repository.PersonRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
    private final PersonRepository repository;

    private final PersonMapper mapper;
    @Override
    public List<PersonDto> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::map).toList();
    }

    @Override
    public PersonDto getPersonById(Long id) {
        return repository.findById(id).map(mapper::map).orElseThrow(RuntimeException::new);
    }
}
