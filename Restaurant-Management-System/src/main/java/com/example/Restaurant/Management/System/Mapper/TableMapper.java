package com.example.Restaurant.Management.System.Mapper;

import com.example.Restaurant.Management.System.Dto.Request.TableRequest;
import com.example.Restaurant.Management.System.Dto.Response.TableResponse;
import com.example.Restaurant.Management.System.Model.MasTable;
import org.springframework.stereotype.Service;

@Service
public class TableMapper {

    public MasTable toEntity(TableRequest tableRequestDTO){
        MasTable t = new MasTable();
        t.setSeats(tableRequestDTO.getSeats());
        t.setOccupied(false);
        t.setTableNumber(tableRequestDTO.getTableNumber());
        return t;
    }

    public TableResponse toDTO(MasTable table){
        return TableResponse.builder()
                .tableNumber(table.getTableNumber())
                .isOccupied(table.isOccupied())
                .seats(table.getSeats())
                .id(table.getId())
                .build();

    }
}
