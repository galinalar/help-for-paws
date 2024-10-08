package paws.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paws.domain.*;

@Repository
public interface PetTestRepository extends CrudRepository<PetTest, Long> {
    @Query(value = "SELECT test.answer FROM PetTest test where test.pet = :pet")
    List<PetAnswer> findAnswersByPet(Pet pet);
    List<PetTest> findByPet(Pet pet);
}
