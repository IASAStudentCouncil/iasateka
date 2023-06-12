package ua.dimalutsyuk.services;

import jakarta.servlet.http.Cookie;

public interface CookieService {
    Cookie generateJwtCookie(String token);
}
