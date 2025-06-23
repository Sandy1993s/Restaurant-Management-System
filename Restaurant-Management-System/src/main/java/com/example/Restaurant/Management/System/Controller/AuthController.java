package com.example.Restaurant.Management.System.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Restaurant.Management.System.Dto.Request.UserRequest;
import com.example.Restaurant.Management.System.Dto.Response.AuthResponse;
import com.example.Restaurant.Management.System.Security.AuthService;
import com.example.Restaurant.Management.System.Dto.Request.AuthRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/signin")
  public ResponseEntity<AuthResponse> login(@RequestBody UserRequest request) {
    return ResponseEntity.ok(authService.login(request));
  }

  @PostMapping("/signup")
  public ResponseEntity<AuthResponse> register(@RequestBody UserRequest request) {
    return ResponseEntity.ok(authService.register(request));
  }

  @PostMapping("/access-token")
  public ResponseEntity<AuthResponse> getAccessToken(@RequestBody AuthRequest request) {
    return ResponseEntity.ok(authService.refreshAccessToken(request.getRefreshToken()));
  }

}
