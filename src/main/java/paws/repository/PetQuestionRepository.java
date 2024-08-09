package paws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paws.domain.PetQuestion;

@Repository
public interface PetQuestionRepository extends CrudRepository<PetQuestion, Long> {
}
