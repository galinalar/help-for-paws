package paws.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import paws.domain.Person;
import paws.repository.PersonRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
    private final PersonRepository repository;
    @Override
    public List<Person> getAll() {
        repository.save(new Person(null, "hew"));
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }

    @Override
    public Person getPersonById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }
}
