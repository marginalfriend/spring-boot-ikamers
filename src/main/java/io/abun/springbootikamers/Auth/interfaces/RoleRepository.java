package io.abun.springbootikamers.Auth.interfaces;

import io.abun.springbootikamers.Auth.Role;
import io.abun.springbootikamers.Auth.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByRole(UserRole role);
}
