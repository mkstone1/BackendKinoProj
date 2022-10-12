package Backendkinoprojekt.repository;

import Backendkinoprojekt.entity.UserWithRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserWithRoles, String> {
    UserWithRoles findUserWithRolesByUsername(String username);
}
