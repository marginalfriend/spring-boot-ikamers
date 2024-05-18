package io.abun.springbootikamers.Auth.dto;

public record AuthRequest(
        String username,
        String password
) {
}
