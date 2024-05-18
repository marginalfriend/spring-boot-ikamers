package io.abun.springbootikamers.Auth.interfaces;

import io.abun.springbootikamers.Auth.Role;
import io.abun.springbootikamers.Auth.UserRole;

public interface RoleService {
    Role getOrSave(UserRole role);
}
