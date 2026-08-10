package com.codingshuttle.sathwik.prod_ready_features;


import com.codingshuttle.sathwik.prod_ready_features.clients.EmployeeClient;
import com.codingshuttle.sathwik.prod_ready_features.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmployeeServiceTests {

    @Autowired
    private EmployeeClient employeeClient;
    @Test
    void employeeServiceTest(){
        List<EmployeeDTO> allEmployees = employeeClient.getAllEmployees();
        for(EmployeeDTO employee : allEmployees){
            System.out.println(employee.getName());
        }
    }
}
