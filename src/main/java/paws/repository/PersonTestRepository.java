package paws.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paws.domain.Person;
import paws.domain.PersonAnswer;
import paws.domain.PersonTest;

import java.util.List;

@Repository
public interface PersonTestRepository extends CrudRepository<PersonTest, Long> {
    @Query(value = "SELECT test.answer FROM PersonTest test where test.person = :person")
    List<PersonAnswer> findAnswersByPerson(Person person);
    List<PersonTest> findByPerson(Person person);
}
