package com.example.Restaurant.Management.System.Controller;

import org.springframework.http.ResponseEntity;
import com.example.Restaurant.Management.System.Dto.Response.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Restaurant.Management.System.Dto.Request.UserRequest;
import com.example.Restaurant.Management.System.Security.AuthService;
import com.example.Restaurant.Management.System.Dto.Request.AuthRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/signin")
  public ResponseEntity login(@RequestBody UserRequest request) {
    return ResponseEntity.ok(new ApiResponse<>(authService.login(request), "success", 200, "Login Successfully"));
  }

  @PostMapping("/signup")
  public ResponseEntity register(@RequestBody UserRequest request) {
    return ResponseEntity.ok(new ApiResponse<>(authService.register(request), "success", 200, "Register Successfully"));
  }

  @PostMapping("/access-token")
  public ResponseEntity getAccessToken(@RequestBody AuthRequest request) {
    return ResponseEntity.ok(new ApiResponse<>(authService.refreshAccessToken(request.getRefreshToken()), "success", 200, "Get Access Token Successfully"));
  }

}
