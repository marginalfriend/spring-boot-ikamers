package io.abun.springbootikamers.Auth.abstraction;

import io.abun.springbootikamers.Auth.UserAccount;
import io.abun.springbootikamers.Auth.dto.JwtClaims;

public interface JwtService {
    String generateToken(UserAccount userAccount);

    boolean verifyJwtToken(String token);

    JwtClaims getClaimsByToken(String token);
}