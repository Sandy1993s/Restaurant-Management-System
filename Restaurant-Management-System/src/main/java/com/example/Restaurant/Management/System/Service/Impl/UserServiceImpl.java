package com.example.Restaurant.Management.System.Service.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import com.example.Restaurant.Management.System.Dto.Request.UserRequest;
import com.example.Restaurant.Management.System.Model.Users;
import com.example.Restaurant.Management.System.Repository.UserRepository;
import com.example.Restaurant.Management.System.Service.Interface.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public Users createUser(UserRequest request) {

    if (userRepository.findByEmail(request.getEmail()).isPresent()) {
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

    userRepository.save(user);
    return user;
  }

  @Override
  public Users getUserById(Long id) {
    Users user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    return user;
  }

  @Override
  public Users updateUser(Long id, UserRequest request) {
    Users user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

    user = user.builder().username(request.getUsername())
        .password(request.getPassword())
        .email(request.getEmail())
        .phoneNumber(request.getPhoneNumber())
        .role(request.getRole())
        .createOn(LocalDateTime.now())
        .build();

    Users updatedUser = userRepository.save(user);
    return updatedUser;
  }

  @Override
  public void delateUserById(Long id) {
    userRepository.deleteById(id);

  }

  @Override
  public List<Users> getAllUsers(Pageable pageable) {
    return userRepository.findAll(pageable).getContent();
  }

}
