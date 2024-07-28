package paws.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import paws.domain.ApplicationUser;
import paws.domain.Person;
import paws.dto.PersonDto;
import paws.mapper.PersonMapper;
import paws.repository.ApplicationUserRepository;
import paws.repository.PersonRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
    private final PersonRepository repository;
    private final ApplicationUserRepository applicationUserRepository;

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

    @Override
    public Person getCurrentUser(String name) {
        ApplicationUser user = applicationUserRepository.findByUsername(name).orElseThrow(RuntimeException::new);
        return user.getPerson();
    }

    @Override
    public Person savePerson(Person person) {
        repository.save(person);
        Person personNew = repository.findByName(person.getName());
        return personNew;
    }
}
