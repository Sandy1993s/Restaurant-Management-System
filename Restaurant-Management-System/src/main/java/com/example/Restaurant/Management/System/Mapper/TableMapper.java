package com.example.Restaurant.Management.System.Mapper;

import com.example.Restaurant.Management.System.Dto.Request.TableRequest;
import com.example.Restaurant.Management.System.Dto.Response.TableResponse;
import com.example.Restaurant.Management.System.Model.Tables;

public class TableMapper {

    public Tables toEntity(TableRequest tableRequestDTO){
        Tables t = new Tables();
        t.setSeats(tableRequestDTO.getSeats());
        t.setOccupied(false);
        t.setTableNumber(tableRequestDTO.getTableNumber());
        t.setSeats(tableRequestDTO.getSeats());
        return t;
    }

    public TableResponse toDTO(Tables table){
        return TableResponse.builder()
                .tableNumber(table.getTableNumber())
                .isOccupied(table.isOccupied())
                .seats(table.getSeats())
                .id(table.getId())
                .build();

    }
}
