package com.example.Restaurant.Management.System.Security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.Restaurant.Management.System.Model.Users;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;

@Service
public class JwtService {

  // private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
  // private final long accessTokenValidity = 1000 * 60 * 60 * 12; // 12 hour
  // private final long refreshTokenValidity = 1000 * 60 * 60 * 24 * 7; // 7 days

  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.access-token-validity}")
  private long accessTokenValidity;

  @Value("${jwt.refresh-token-validity}")
  private long refreshTokenValidity;

  private Key getSigningKey() {
    return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
  }

  public String generateToken(Users user, boolean isRefresh) {
    long validity = isRefresh ? refreshTokenValidity : accessTokenValidity;
    return Jwts.builder()
        .setSubject(user.getUsername())
        .claim("role", user.getRole().name()) // 👈 include role
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + validity))
        .signWith(getSigningKey())
        .compact();
  }

  public boolean isTokenValid(String token) {
    try {
      Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
      return true;
    } catch (JwtException e) {
      return false;
    }
  }

  public String extractUsername(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(getSigningKey())
        .build()
        .parseClaimsJws(token)
        .getBody()
        .getSubject();
  }

  public long getAccessTokenValidity() {
    return accessTokenValidity;
  }

  public long getRefreshTokenValidity() {
    return refreshTokenValidity;
  }

}
