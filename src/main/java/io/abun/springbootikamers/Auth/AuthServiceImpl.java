package io.abun.springbootikamers.Auth;

import io.abun.springbootikamers.Auth.abstraction.AuthService;
import io.abun.springbootikamers.Auth.dto.AuthRequest;
import io.abun.springbootikamers.Auth.dto.LoginResponse;
import io.abun.springbootikamers.Auth.dto.RegisterResponse;

public class AuthServiceImpl implements AuthService {
    @Override
    public RegisterResponse register(AuthRequest request) {
        return null;
    }

    @Override
    public RegisterResponse registerAdmin(AuthRequest request) {
        return null;
    }

    @Override
    public LoginResponse login(AuthRequest request) {
        return null;
    }
}
