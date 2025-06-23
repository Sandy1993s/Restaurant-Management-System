package com.example.Restaurant.Management.System.Repository;

import com.example.Restaurant.Management.System.Model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TableRepository extends JpaRepository<Table, Long> {
    Optional<Table> findByTableNumber(int tableNumber);
    //boolean existsByTableNumber(Long tableNumber);
    Optional<Table> findById(Long id);
}
