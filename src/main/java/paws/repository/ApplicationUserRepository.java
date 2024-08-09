package paws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import paws.domain.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByUsernameAndActive(String username, int active);
    boolean existsByUsername(String username);
}
