package paws.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import paws.domain.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    Optional<UserRole> findByRoleType(UserRole.RoleType roleType);
}
