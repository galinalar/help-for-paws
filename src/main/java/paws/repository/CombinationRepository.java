package paws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paws.domain.Combination;
import paws.domain.PersonAnswer;

@Repository
public interface CombinationRepository extends CrudRepository<Combination, Long> {
}
