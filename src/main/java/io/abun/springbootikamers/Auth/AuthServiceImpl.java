package io.abun.springbootikamers.Auth;

import io.abun.springbootikamers.Auth.abstraction.AuthService;
import io.abun.springbootikamers.Auth.abstraction.RoleService;
import io.abun.springbootikamers.Auth.abstraction.UserAccountRepository;
import io.abun.springbootikamers.Auth.dto.AuthRequest;
import io.abun.springbootikamers.Auth.dto.LoginResponse;
import io.abun.springbootikamers.Auth.dto.RegisterResponse;
import io.abun.springbootikamers.CustomerServices.CustomerEntity;
import io.abun.springbootikamers.CustomerServices.CustomerService;
import io.abun.springbootikamers.CustomerServices.DTO.Customer;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class AuthServiceImpl implements AuthService {
    RoleService roleService;
    PasswordEncoder passwordEncoder;
    UserAccountRepository userAccountRepository;
    CustomerService customerService;

    @Override
    public RegisterResponse register(AuthRequest request) {
        Role role = roleService.getOrSave(UserRole.ROLE_CUSTOMER);

        String hashedPassword = passwordEncoder.encode(request.password());

        UserAccount account = UserAccount.builder()
                .username(request.username())
                .password(hashedPassword)
                .role(List.of(role))
                .build();

        userAccountRepository.saveAndFlush(account);

        CustomerEntity customer = CustomerEntity.builder()
                .membership(true)
                .account(account)
                .build();

        customerService.addNewCustomer(customer);
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
