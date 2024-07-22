package paws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paws.domain.Person;
import paws.domain.PersonAnswer;

@Repository
public interface PersonAnswerRepository extends CrudRepository<PersonAnswer, Long> {
}
