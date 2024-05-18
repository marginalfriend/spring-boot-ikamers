package io.abun.springbootikamers.Auth.dto;

import java.util.List;

public record JwtClaims(
        String userAccountId,
        List<String> roles
) {
}
