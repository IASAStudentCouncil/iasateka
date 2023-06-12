package ua.dimalutsyuk.services.impl;

import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.dimalutsyuk.services.CookieService;

@Service
public class CookieServiceImpl implements CookieService {
    private static final String JWT_COOKIE_NAME = "jwtToken";
    @Value("${jwt.living-time.seconds}")
    private String jwtCookieLivingTime;

    @Override
    public Cookie generateJwtCookie(String token) {
        Cookie jwtCookie = new Cookie(JWT_COOKIE_NAME, token);
        jwtCookie.setHttpOnly(true);
        jwtCookie.setMaxAge(Integer.parseInt(jwtCookieLivingTime));
        return jwtCookie;
    }
}
