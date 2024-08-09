package paws.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import paws.domain.ApplicationUser;
import paws.domain.UserRole;
import paws.exception.PawsException;
import paws.repository.ApplicationUserRepository;
import paws.repository.UserRoleRepository;

import javax.security.auth.login.AccountException;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final ApplicationUserRepository applicationUserRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public void registration(ApplicationUser user) throws AccountException {
        if (applicationUserRepository.existsByUsername(user.getUsername())) {
            throw new AccountException("Username is already taken");
        }
        userRoleRepository.findByRoleType(UserRole.RoleType.ROLE_USER)
                .ifPresentOrElse(user::setUserRole,
                        () -> {
                            UserRole userRole = new UserRole();
                            userRole.setRoleType(UserRole.RoleType.ROLE_USER);
                            user.setUserRole(userRole);
                            userRoleRepository.save(userRole);
                        }
                );
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

    public void updateUser(ApplicationUser user) throws AccountException {
        applicationUserRepository.save(user);
    }

    public ApplicationUser getUser(String name) throws AccountException, PawsException {
        return applicationUserRepository.findByUsernameAndActive(name, 1)
                .orElseThrow(()->new PawsException("Пользователь не найден"));
    }
}
