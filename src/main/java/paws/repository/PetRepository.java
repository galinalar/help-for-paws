package paws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paws.domain.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
