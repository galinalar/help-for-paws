package paws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paws.domain.PersonQuestion;

@Repository
public interface PersonQuestionRepository extends CrudRepository<PersonQuestion, Long> {
}
