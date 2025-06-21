package com.example.Restaurant.Management.System.Dto.Request;

import java.time.LocalDateTime;

import com.example.Restaurant.Management.System.Enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
  String username;

  String password;

  String email;

  String phoneNumber;

  Role role;

  LocalDateTime createOn;
}
