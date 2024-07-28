package paws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paws.domain.Person;
import paws.domain.PersonTest;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByName(String name);
}
