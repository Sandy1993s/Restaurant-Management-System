package com.example.Restaurant.Management.System.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Restaurant.Management.System.Model.Users;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @PostMapping("/register")
  ResponseEntity<String> registerUser(@RequestBody Users user) {
    return ResponseEntity.ok("User Registered Successfully");
  }

}
