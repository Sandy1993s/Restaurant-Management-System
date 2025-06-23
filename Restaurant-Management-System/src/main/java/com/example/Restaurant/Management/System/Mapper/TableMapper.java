package com.example.Restaurant.Management.System.Mapper;

import com.example.Restaurant.Management.System.Dto.Request.TableRequest;
import com.example.Restaurant.Management.System.Dto.Response.TableResponse;
import com.example.Restaurant.Management.System.Model.Table;

public class TableMapper {

    public Table toEntity(TableRequest tableRequestDTO){
        Table t = new Table();
        t.setSeats(tableRequestDTO.getSeats());
        t.setOccupied(false);
        t.setTableNumber(tableRequestDTO.getTableNumber());
        t.setSeats(tableRequestDTO.getSeats());
        return t;
    }

    public TableResponse toDTO(Table table){
        return TableResponse.builder()
                .tableNumber(table.getTableNumber())
                .isOccupied(table.isOccupied())
                .seats(table.getSeats())
                .id(table.getId())
                .build();

    }
}
