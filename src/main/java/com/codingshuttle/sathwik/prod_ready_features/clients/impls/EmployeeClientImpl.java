package com.codingshuttle.sathwik.prod_ready_features.clients.impls;

import com.codingshuttle.sathwik.prod_ready_features.advices.ApiResponse;
import com.codingshuttle.sathwik.prod_ready_features.clients.EmployeeClient;
import com.codingshuttle.sathwik.prod_ready_features.dto.EmployeeDTO;
import com.codingshuttle.sathwik.prod_ready_features.exceptions.RescourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@RequiredArgsConstructor

@Service
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        try{
            ApiResponse<List<EmployeeDTO>> employeeDTOList =restClient.get()
                    .uri("employees")
                    .retrieve()
                    .onStatus(HttpStatusCode::is5xxServerError,(req,res)->{
                        throw new RescourceNotFoundException("could not find employee list");
                    })
                    .body(new ParameterizedTypeReference<ApiResponse<List<EmployeeDTO>>>() {
                    });
            assert employeeDTOList != null;
            return employeeDTOList.getData();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
