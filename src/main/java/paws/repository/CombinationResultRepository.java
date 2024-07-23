package paws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paws.domain.Combination;
import paws.domain.CombinationResult;

@Repository
public interface CombinationResultRepository extends CrudRepository<CombinationResult, Long> {
}
