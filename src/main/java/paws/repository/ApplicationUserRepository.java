package paws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import paws.domain.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByUsername(String username);
    boolean existsByUsername(String username);
}
