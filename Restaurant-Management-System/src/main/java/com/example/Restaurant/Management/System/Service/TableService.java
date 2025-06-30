package com.example.Restaurant.Management.System.Service;

import com.example.Restaurant.Management.System.Dto.Request.UserRequest;
import com.example.Restaurant.Management.System.Model.MasTable;

public interface TableService {

    MasTable updateTable(Long id, UserRequest request);
}
