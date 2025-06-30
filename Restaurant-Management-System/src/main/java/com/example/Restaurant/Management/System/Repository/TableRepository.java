package com.example.Restaurant.Management.System.Repository;

import com.example.Restaurant.Management.System.Model.MasTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TableRepository extends JpaRepository<MasTable, Long> {
    Optional<MasTable> findByTableNumber(int tableNumber);
    //boolean existsByTableNumber(Long tableNumber);
    Optional<MasTable> findById(Long id);
}
