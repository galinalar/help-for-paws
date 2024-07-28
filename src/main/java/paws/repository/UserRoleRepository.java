package paws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import paws.domain.UserRole;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    Optional<UserRole> findByRoleType(UserRole.RoleType roleType);
}
