package com.example.Restaurant.Management.System.Dto.Response;

import com.example.Restaurant.Management.System.Enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

  private String accessToken;
  private String refreshToken;
  private Role role;
  private String username;
  private long accessTokenExpiry;
  private long refreshTokenExpiry;
}
