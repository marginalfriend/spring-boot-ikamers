package io.abun.springbootikamers.Auth.dto;

import java.util.List;

public record RegisterResponse(
        String userName,
        List<String> roles
) {
}
