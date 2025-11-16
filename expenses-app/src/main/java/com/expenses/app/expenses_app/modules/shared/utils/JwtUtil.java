package com.expenses.app.expenses_app.modules.shared.utils;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil {
    
    @Value("${app.jwt.secret}")
    private String jwtSecret;

    private SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.jwtSecret));
    }

    private Boolean isTokenExpired(String token){
        Date jwtExpiration = Jwts.parser().verifyWith(this.getSigningKey()).build().parseSignedClaims(token).getPayload().getExpiration();

        if (jwtExpiration.before(new Date())){
            return true;
        }

        return false;
    }

    public String generateToken(String email){
        return Jwts.builder()
        .subject(email)
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis()  + (1000 * 60 * 60)))
        .signWith(this.getSigningKey())
        .compact();
    }

    public String extractEmail(String token){
        return Jwts.parser().verifyWith(this.getSigningKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public Boolean isTokenValid(String token, String email){
        String tokenEmail = this.extractEmail(token);

        if (tokenEmail.equals(email) && !this.isTokenExpired(token)){
            return true;
        }

        return false;
    }
}
