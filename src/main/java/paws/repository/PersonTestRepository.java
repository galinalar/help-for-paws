package paws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paws.domain.PersonAnswer;
import paws.domain.PersonTest;

@Repository
public interface PersonTestRepository extends CrudRepository<PersonTest, Long> {
}
