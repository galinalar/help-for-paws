package paws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paws.domain.PersonTest;
import paws.domain.PetTest;

@Repository
public interface PetTestRepository extends CrudRepository<PetTest, Long> {
}
