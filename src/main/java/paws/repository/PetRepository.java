package paws.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paws.domain.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
    List<Pet> findByShelterIdAndActive(Long id, int active);
}
