package com.example.Restaurant.Management.System.Controller;

import java.util.List;

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
  ResponseEntity<String> registerUser(@RequestBody UserRequest request) {
    Users user = userService.createUser(request);
    return ResponseEntity.ok("User Registered Successfully" + user);
  }

  @GetMapping("/{id}")
  ResponseEntity<String> getUserById(@PathVariable Long id) {
    Users user = userService.getUserById(id);
    return ResponseEntity.ok("User Get Successfully" + user);
  }

  @GetMapping("/all")
  ResponseEntity<String> getAllUsers() {
    List<Users> users = userService.getAllUsers();
    return ResponseEntity.ok("All Users Get Successfully" + users);

  }

  @PutMapping("/{id}")
  ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserRequest request) {
    Users user = userService.updateUser(id, request);
    return ResponseEntity.ok("User Updated Successfully" + user);
  }

  @DeleteMapping("/{id}")
  ResponseEntity<String> deleteUser(@PathVariable Long id) {
    userService.delateUserById(id);
    return ResponseEntity.ok("User Deleted Successfully");
  }

}
