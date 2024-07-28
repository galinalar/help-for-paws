package paws.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paws.domain.ApplicationUser;
import paws.domain.Combination;
import paws.domain.PersonAnswer;
import paws.domain.PetAnswer;

import java.util.Optional;

@Repository
public interface CombinationRepository extends CrudRepository<Combination, Long> {
    @Query(value = "SELECT c.result FROM Combination c where c.personAnswer = :personAnswer and c.petAnswer = :petAnswer")
    Optional<Integer> findResultByPetAnswerAndPersonAnswer(PersonAnswer personAnswer, PetAnswer petAnswer);
    Optional<Combination> findByPetAnswerAndPersonAnswer(PersonAnswer personAnswer, PetAnswer petAnswer);
}
