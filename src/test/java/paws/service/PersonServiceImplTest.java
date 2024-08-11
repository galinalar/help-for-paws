package paws.service;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import paws.domain.ApplicationUser;
import paws.domain.Person;
import paws.domain.UserRole;
import paws.dto.PersonDto;
import paws.exception.PawsException;
import paws.mapper.PersonMapper;
import paws.mapper.PersonMapperImpl;
import paws.repository.ApplicationUserRepository;
import paws.repository.PersonRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {PersonServiceImpl.class, PersonMapperImpl.class})
class PersonServiceImplTest {

    @MockBean
    private PersonRepository repository;
    @MockBean
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private PersonMapper mapper;
    @Autowired
    private PersonService personService;
    Person person = new Person(1L, "name", 1);
    ApplicationUser applicationUser = new ApplicationUser(1L, "name", "",
            new UserRole(1, UserRole.RoleType.ROLE_USER), person, 1);

    @Test
    void getPersonById() throws PawsException {
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(person));
        PersonDto personDto = personService.getPersonById(1L);
        assertEquals(mapper.map(person), personDto);
    }

    @Test
    void getCurrentUser() throws PawsException {
        when(applicationUserRepository.findByUsernameAndActive("name", 1))
                .thenReturn(Optional.ofNullable(applicationUser));
        Person person1 = personService.getCurrentUser("name");
        assertEquals(person1, person);
    }

    @Test
    void savePerson() {

        when(repository.findByNameAndActive("name", 1)).thenReturn(person);
        Person person1 = personService.savePerson(person);

        ArgumentCaptor<Person> captor = ArgumentCaptor.forClass(Person.class);
        verify(repository).save(captor.capture());
        assertEquals(captor.getValue().getName(), person.getName());
    }

    @Test
    void updatePerson() {
        Person person1 = personService.savePerson(person);
        personService.updatePerson(1L, "2");

        ArgumentCaptor<Person> captor = ArgumentCaptor.forClass(Person.class);
        verify(repository, times(2)).save(captor.capture());
        assertEquals("2", captor.getValue().getName());
    }
}