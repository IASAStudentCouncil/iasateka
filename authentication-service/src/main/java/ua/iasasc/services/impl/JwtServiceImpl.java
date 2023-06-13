package ua.iasasc.services.impl;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ua.iasasc.exceptions.TokenException;
import ua.iasasc.services.JwtService;

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

    @Override
    public void verifyToken(String token, String email) {
        JwtParser parser = buildParser(email);
        Jws<Claims> claims = parser.parseClaimsJws(token);
        Date expirationDate = claims.getBody().getExpiration();
        if (expirationDate != null) {
            if (expirationDate.after(new Date())) {
                throw new TokenException("Token expired", HttpStatus.FORBIDDEN);
            }
        } else {
            throw new TokenException("Expiration date absent in jwt token", HttpStatus.FORBIDDEN);
        }
    }

    private JwtParser buildParser(String email) {
        return Jwts
                .parserBuilder()
                .setSigningKey(signingKey.getBytes())
                .requireSubject(email)
                .build();
    }
}
