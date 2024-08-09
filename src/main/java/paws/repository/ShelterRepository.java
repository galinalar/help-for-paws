package paws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paws.domain.Shelter;

import java.util.List;

@Repository
public interface ShelterRepository extends CrudRepository<Shelter, Long> {

     List<Shelter> findByActive(int active);
}
