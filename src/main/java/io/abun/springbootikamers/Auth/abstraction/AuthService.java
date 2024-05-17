package io.abun.springbootikamers.Auth.abstraction;

import io.abun.springbootikamers.Auth.dto.AuthRequest;
import io.abun.springbootikamers.Auth.dto.LoginResponse;
import io.abun.springbootikamers.Auth.dto.RegisterResponse;

public interface AuthService {
    RegisterResponse register(AuthRequest request);
    RegisterResponse registerAdmin(AuthRequest request);
    LoginResponse login(AuthRequest request);
}
