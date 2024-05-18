package io.abun.springbootikamers.Auth;

import io.abun.springbootikamers.Auth.dto.AuthRequest;
import io.abun.springbootikamers.Auth.dto.RegisterResponse;
import io.abun.springbootikamers.Auth.interfaces.AuthService;
import io.abun.springbootikamers.Constants.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/auth")
public class AuthController {
    final AuthService authService;

    @PostMapping(path = "/register")
    public ResponseEntity<CommonResponse<?>> register(@RequestBody AuthRequest request) {
        RegisterResponse register = authService.register(request);

        CommonResponse<RegisterResponse> response = new CommonResponse<>(
                HttpStatus.CREATED.value(),
                "Registration success",
                register,
                null
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
