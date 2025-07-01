package com.example.Restaurant.Management.System.Service.Interface;

import java.util.List;  
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.example.Restaurant.Management.System.Dto.Request.UserRequest;
import com.example.Restaurant.Management.System.Model.Users;

@Service
public interface UserService {

  Users createUser(UserRequest request);

  Users getUserById(Long id);

  Users updateUser(Long id, UserRequest request);

  void delateUserById(Long id);

  List<Users> getAllUsers(Pageable pageable);
}
