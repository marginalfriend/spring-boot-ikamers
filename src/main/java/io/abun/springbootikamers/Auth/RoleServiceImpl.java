package io.abun.springbootikamers.Auth;

import io.abun.springbootikamers.Auth.abstraction.RoleRepository;
import io.abun.springbootikamers.Auth.abstraction.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    RoleRepository repository;

    @Override
    public Role getOrSave(UserRole role) {
        return repository.findByRole(role).orElseGet(
                () -> repository.saveAndFlush(
                        Role.builder()
                                .role(role)
                                .build()
                )
        );
    }
}
