package io.abun.springbootikamers.Auth.abstraction;

import io.abun.springbootikamers.Auth.Role;
import io.abun.springbootikamers.Auth.UserRole;

public interface RoleService {
    Role getOrSave(UserRole role);
}
