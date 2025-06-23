package com.example.Restaurant.Management.System.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "table_number", unique = true, nullable = false)
    private int tableNumber;

    @Column(nullable = false)
    private int seats;

    @Column(name = "is_occupied", columnDefinition = "boolean default false")
    private boolean isOccupied;
}
