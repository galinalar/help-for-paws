package paws.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import paws.domain.ApplicationUser;
import paws.domain.Person;
import paws.dto.PersonDto;
import paws.exception.PawsException;
import paws.mapper.PersonMapper;
import paws.repository.ApplicationUserRepository;
import paws.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
    private final PersonRepository repository;
    private final ApplicationUserRepository applicationUserRepository;

    private final PersonMapper mapper;

    @Override
    public PersonDto getPersonById(Long id) throws PawsException {
        return repository.findById(id).map(mapper::map).orElseThrow(()->new PawsException("Пользователь не найден"));
    }

    @Override
    public Person getCurrentUser(String name) throws PawsException {
        ApplicationUser user = applicationUserRepository.findByUsernameAndActive(name, 1)
                .orElseThrow(()->new PawsException("Нет такого пользователя"));
        return user.getPerson();
    }

    @Override
    public Person savePerson(Person person) {
        repository.save(person);
        Person personNew = repository.findByNameAndActive(person.getName(), 1);
        return personNew;
    }

    @Override
    public void updatePerson(Long id, String name) {
        repository.save(new Person(id, name, 1));
    }
}
