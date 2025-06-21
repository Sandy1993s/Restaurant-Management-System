package com.example.Restaurant.Management.System.Service.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Restaurant.Management.System.Dto.Request.UserRequest;
import com.example.Restaurant.Management.System.Model.Users;
import com.example.Restaurant.Management.System.Repositorey.UserRepositorey;
import com.example.Restaurant.Management.System.Service.Interface.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepositorey userRepositorey;

  @Override
  public Users createUser(UserRequest request) {

    if (userRepositorey.findByEmail(request.getEmail()).isPresent()) {
      throw new RuntimeException("User already exists");
    }
    Users user = Users.builder()
        .username(request.getUsername())
        .password(request.getPassword())
        .email(request.getEmail())
        .phoneNumber(request.getPhoneNumber())
        .role(request.getRole())
        .createOn(LocalDateTime.now())
        .build();

    userRepositorey.save(user);
    return user;
  }

  @Override
  public Users getUserById(Long id) {
    Users user = userRepositorey.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    return user;
  }

  @Override
  public Users updateUser(Long id, UserRequest request) {
    Users user = userRepositorey.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

    user = user.builder().username(request.getUsername())
        .password(request.getPassword())
        .email(request.getEmail())
        .phoneNumber(request.getPhoneNumber())
        .role(request.getRole())
        .createOn(LocalDateTime.now())
        .build();

    Users updatedUser = userRepositorey.save(user);
    return updatedUser;
  }

  @Override
  public void delateUserById(Long id) {
    userRepositorey.deleteById(id);

  }

  @Override
  public List<Users> getAllUsers() {
    return userRepositorey.findAll();
  }

}
