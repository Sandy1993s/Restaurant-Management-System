package com.example.Restaurant.Management.System.Dto.Response;

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
  private String username;
  private long accessTokenExpiry;
  private long refreshTokenExpiry;
}
