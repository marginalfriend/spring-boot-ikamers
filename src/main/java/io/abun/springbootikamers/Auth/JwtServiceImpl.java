package io.abun.springbootikamers.Auth;

import org.springframework.beans.factory.annotation.Value;

public class JwtServiceImpl {
    final String JWT_SECRET;
    final String ISSUER;
    final long JWT_EXPIRATION;

    public JwtServiceImpl(
            @Value("${enigma_shop.jwt.secret_key}") String jwtSecret,
            @Value("${enigma_shop.jwt.issuer}") String issuer,
            @Value("${enigma_shop.jwt.expirationInSecond}") long expiration
    ) {
        JWT_SECRET = jwtSecret;
        ISSUER = issuer;
        JWT_EXPIRATION = expiration;
    }
}
