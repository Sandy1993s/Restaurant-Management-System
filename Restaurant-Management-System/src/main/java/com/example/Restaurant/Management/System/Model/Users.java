package com.example.Restaurant.Management.System.Model;

import java.time.LocalDateTime;
import java.util.Date;

import com.example.Restaurant.Management.System.Enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  String username;

  String password;

  String email;

  String phoneNumber;

  @Enumerated(EnumType.STRING)
  Role role;

  LocalDateTime createOn;
}
