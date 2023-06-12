package ua.dimalutsyuk.services.impl;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.dimalutsyuk.services.JwtService;

import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {
    @Value("${HS512-secret-key}")
    private String signingKey;
    @Value("${jwt.living-time.seconds}")
    private String jwtLivingTime;

    @Override
    public String generateTokenByEmail(String email) {
        JwtBuilder builder = Jwts.builder();
        return builder.setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(jwtLivingTime) * 1000))
                .signWith(Keys.hmacShaKeyFor(signingKey.getBytes()))
                .compact();
    }
}
