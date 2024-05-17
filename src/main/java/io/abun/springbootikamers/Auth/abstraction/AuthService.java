package io.abun.springbootikamers.Auth.abstraction;

import io.abun.springbootikamers.Auth.abstraction.dto.AuthRequest;
import io.abun.springbootikamers.Auth.abstraction.dto.LoginResponse;
import io.abun.springbootikamers.Auth.abstraction.dto.RegisterResponse;

public interface AuthService {
    RegisterResponse register(AuthRequest request);
    RegisterResponse registerAdmin(AuthRequest request);
    LoginResponse login(AuthRequest request);
}
