package com.example.Restaurant.Management.System.Controller;

import java.util.List;
import java.util.HashMap;

import com.example.Restaurant.Management.System.Dto.Response.ApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Restaurant.Management.System.Dto.Request.UserRequest;
import com.example.Restaurant.Management.System.Model.Users;
import com.example.Restaurant.Management.System.Service.Interface.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  ResponseEntity registerUser(@RequestBody UserRequest request) {
    Users user = userService.createUser(request);
    return ResponseEntity.ok(new ApiResponse<>(user, "success", 200, "User Registered Successfully"));
  }

  @GetMapping("/{id}")
  ResponseEntity getUserById(@PathVariable Long id) {
    Users user = userService.getUserById(id);
    return ResponseEntity.ok(new ApiResponse<>(user, "success", 200, "User Get Successfully"));
  }

  @GetMapping("/all")
  ResponseEntity getAllUsers(Pageable pageable) {
    List<Users> users = userService.getAllUsers(pageable);
    return ResponseEntity.ok(new ApiResponse<>(users, "success", 200, "All Users Get Successfully"));

  }

  @PutMapping("/{id}")
  ResponseEntity updateUser(@PathVariable Long id, @RequestBody UserRequest request) {
    Users user = userService.updateUser(id, request);
    return ResponseEntity.ok(new ApiResponse<>(user, "success", 200, "User Updated Successfully"));
  }

  @DeleteMapping("/{id}")
  ResponseEntity deleteUser(@PathVariable Long id) {
    userService.delateUserById(id);
    return ResponseEntity.ok(new ApiResponse<>(null, "success", 200, "User Deleted Successfully"));
  }

}
