package com.example.Restaurant.Management.System.Service.Impl;

import com.example.Restaurant.Management.System.Dto.Request.TableRequest;
import com.example.Restaurant.Management.System.Dto.Response.TableResponse;
import com.example.Restaurant.Management.System.Mapper.TableMapper;
import com.example.Restaurant.Management.System.Model.MasTable;
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
@Autowired
    private TableMapper tableMapper;


    @Override
    public TableResponse createTable(TableRequest tableRequest) {
        Optional<MasTable> data = tableRepository.findByTableNumber(tableRequest.getTableNumber());
        if (data.isPresent()) {
            throw new RuntimeException("Table number already exists");
        }
        MasTable table = tableMapper.toEntity(tableRequest);
        MasTable savedTable = tableRepository.save(table);
        return tableMapper.toDTO(savedTable);
    }

    @Override
    public TableResponse getTableById(Long id) {
        MasTable table = tableRepository.findById(id)
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
        MasTable existingTable = tableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Table not found with id: " + id));

        existingTable.setTableNumber(tableRequestDTO.getTableNumber());
        existingTable.setSeats(tableRequestDTO.getSeats());
        MasTable updatedTable = tableRepository.save(existingTable);
        return tableMapper.toDTO(updatedTable);
    }

    @Override
    public void deleteTable(Long id) {
        MasTable table = tableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Table not found with id: " + id));
        tableRepository.delete(table);
    }

    @Override
    public TableResponse updateOccupiedStatus(Long id, boolean isOccupied) {
        MasTable table = tableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Table not found with id: " + id));
        table.setOccupied(isOccupied);
        MasTable updatedTable = tableRepository.save(table);
        return tableMapper.toDTO(updatedTable);
    }

}
