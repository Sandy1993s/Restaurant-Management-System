package com.example.Restaurant.Management.System.Service.Impl;

import com.example.Restaurant.Management.System.Dto.Request.TableRequest;
import com.example.Restaurant.Management.System.Dto.Response.TableResponse;
import com.example.Restaurant.Management.System.Mapper.TableMapper;
import com.example.Restaurant.Management.System.Model.Table;
import com.example.Restaurant.Management.System.Repository.TableRepository;
import com.example.Restaurant.Management.System.Service.Interface.TableService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TableServiceImpl implements TableService {
@Autowired
    private TableRepository tableRepository;
    private TableMapper tableMapper;

    @Override
    public TableResponse createTable(TableRequest tableRequest) {
        Optional<Table> data = tableRepository.findByTableNumber(tableRequest.getTableNumber());
        if (data.isPresent()) {
            throw new RuntimeException("Table number already exists");
        }

        Table table = tableMapper.toEntity(tableRequest);
        Table savedTable = tableRepository.save(table);
        return tableMapper.toDTO(savedTable);
    }

    @Override
    public TableResponse getTableById(Long id) {
        Table table = tableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Table not found with id: " + id));
        return tableMapper.toDTO(table);
    }

    @Override
    public List<TableResponse> getAllTables() {
        return tableRepository.findAll().stream()
                .map(table -> tableMapper.toDTO(table))
                .collect(Collectors.toList());
    }

    @Override
    public TableResponse updateTable(Long id, TableRequest tableRequestDTO) {
        Table existingTable = tableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Table not found with id: " + id));

        existingTable.setTableNumber(tableRequestDTO.getTableNumber());
        existingTable.setSeats(tableRequestDTO.getSeats());
        Table updatedTable = tableRepository.save(existingTable);
        return tableMapper.toDTO(updatedTable);
    }

    @Override
    public void deleteTable(Long id) {
        Table table = tableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Table not found with id: " + id));
        tableRepository.delete(table);
    }

    @Override
    public TableResponse updateOccupiedStatus(Long id, boolean isOccupied) {
        Table table = tableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Table not found with id: " + id));
        table.setOccupied(isOccupied);
        Table updatedTable = tableRepository.save(table);
        return tableMapper.toDTO(updatedTable);
    }

}
