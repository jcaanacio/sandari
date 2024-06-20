package com.sandari.rain.intrastructure.components;

import java.security.Key;
import java.util.Date;

import com.sandari.rain.application.components.TokenPayload;
import com.sandari.rain.application.interfaces.IApplicationTokenization;
import com.sandari.rain.application.interfaces.IApplicationTokenizationPayload;
import com.sandari.rain.domain.enums.DomainUserRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtTokenization implements IApplicationTokenization {
    private final Key _key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static String userId = "user_id";
    private static String username = "username";
    private static String role = "role";

    public boolean verify(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(this._key)
                    .build()
                    .parseClaimsJws(token);

            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public String sign(IApplicationTokenizationPayload payload) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 600000); // 10 minutes expiration

        Claims claims = Jwts.claims();
        claims.put(JwtTokenization.userId, payload.getId());
        claims.put(JwtTokenization.username, payload.getUsername());
        claims.put(JwtTokenization.role, payload.getUserRole());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(this._key)
                .compact();
    }

    public String refresh(IApplicationTokenizationPayload payload) {
        return this.sign(payload);
    }

    public IApplicationTokenizationPayload getPayload(String token) {
        Claims claim = Jwts.parserBuilder()
                    .setSigningKey(this._key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

        Long userId = Long.parseLong(claim.get(JwtTokenization.userId).toString());
        String username =  claim.get(JwtTokenization.username).toString();
        DomainUserRole role = DomainUserRole.valueOf(claim.get(JwtTokenization.role).toString());

        return new TokenPayload(userId, username, role);
    }
    
}
