package com.example.Restaurant.Management.System.Service;

import com.example.Restaurant.Management.System.Dto.Request.UserRequest;
import com.example.Restaurant.Management.System.Model.Table;
import com.example.Restaurant.Management.System.Model.Users;

public interface TableService {

    Table updateTable(Long id, UserRequest request);
}
