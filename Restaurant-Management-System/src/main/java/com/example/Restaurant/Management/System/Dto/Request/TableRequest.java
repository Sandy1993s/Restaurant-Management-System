package com.example.Restaurant.Management.System.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TableRequest {
    private int tableNumber;
    private int seats;
}
