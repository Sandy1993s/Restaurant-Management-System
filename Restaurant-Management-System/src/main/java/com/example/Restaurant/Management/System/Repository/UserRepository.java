package com.example.Restaurant.Management.System.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Restaurant.Management.System.Model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

  @Query("SELECT u FROM Users u WHERE u.email = :email")
  Optional<Users> findByEmail(@Param("email") String email);
}
