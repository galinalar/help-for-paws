package paws.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import paws.domain.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByUsernameAndActive(String username, int active);
    boolean existsByUsername(String username);
}
