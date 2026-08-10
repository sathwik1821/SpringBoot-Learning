package com.codingshuttle.sathwik.prod_ready_features.clients;

import com.codingshuttle.sathwik.prod_ready_features.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployees();
}
