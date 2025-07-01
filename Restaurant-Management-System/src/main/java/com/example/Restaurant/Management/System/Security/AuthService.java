package com.example.Restaurant.Management.System.Security;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Restaurant.Management.System.Dto.Request.UserRequest;
import com.example.Restaurant.Management.System.Dto.Response.AuthResponse;
import com.example.Restaurant.Management.System.Enums.Role;
import com.example.Restaurant.Management.System.Model.Users;
import com.example.Restaurant.Management.System.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final UserRepository userRepository;
  private final JwtService jwtService;
  private final PasswordEncoder passwordEncoder;

  public AuthResponse register(UserRequest request) {
    if (userRepository.findByUsername(request.getUsername()).isPresent()) {
      throw new RuntimeException("Username already exists");
    }

    Users newUser = Users.builder()
        .username(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .email(request.getEmail())
        .phoneNumber(request.getPhoneNumber())
        .role(request.getRole() == null ? Role.CUSTOMER : request.getRole())
        .createOn(request.getCreateOn() == null ? LocalDateTime.now() : request.getCreateOn())
        .build();

    userRepository.save(newUser);
    return buildResponse(newUser);
  }

  public AuthResponse login(UserRequest request) {
    Users user = userRepository.findByUsername(request.getUsername())
        .orElseThrow(() -> new RuntimeException("User not found"));

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      throw new RuntimeException("Invalid password");
    }

    return buildResponse(user);
  }

  public AuthResponse refreshAccessToken(String refreshToken) {
    if (!jwtService.isTokenValid(refreshToken)) {
      throw new RuntimeException("Invalid refresh token");
    }
    String username = jwtService.extractUsername(refreshToken);
    Users user = userRepository.findByUsername(username)
        .orElseThrow(() -> new RuntimeException("User not found"));
    // Optionally, you can check if the user's role matches the one in the token
    return buildResponse(user);
  }

  private AuthResponse buildResponse(Users user) {
    String accessToken = jwtService.generateToken(user, false);
    String refreshToken = jwtService.generateToken(user, true);
    return AuthResponse.builder()
        .accessToken(accessToken)
        .refreshToken(refreshToken)
        .username(user.getUsername())
        .role(user.getRole())
        .accessTokenExpiry(jwtService.getAccessTokenValidity())
        .refreshTokenExpiry(jwtService.getRefreshTokenValidity())
        .build();
  }

}
