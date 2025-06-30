package com.example.Restaurant.Management.System.Service.Interface;

import com.example.Restaurant.Management.System.Dto.Request.TableRequest;
import com.example.Restaurant.Management.System.Dto.Response.TableResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TableService {
    TableResponse createTable(TableRequest tableRequestDTO);
    TableResponse getTableById(Long id);
    List<TableResponse> getAllTables();
    TableResponse updateTable(Long id, TableRequest tableRequestDTO);
    void deleteTable(Long id);
    TableResponse updateOccupiedStatus(Long id, boolean isOccupied);
}
