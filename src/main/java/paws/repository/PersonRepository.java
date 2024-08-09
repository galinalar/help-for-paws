package paws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paws.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByNameAndActive(String name, int active);
}
