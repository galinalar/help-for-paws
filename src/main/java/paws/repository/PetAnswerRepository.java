package paws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paws.domain.PetAnswer;

@Repository
public interface PetAnswerRepository extends CrudRepository<PetAnswer, Long> {
}
