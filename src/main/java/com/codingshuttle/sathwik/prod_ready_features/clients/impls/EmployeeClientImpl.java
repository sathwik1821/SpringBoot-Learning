package com.codingshuttle.sathwik.prod_ready_features.clients.impls;

import com.codingshuttle.sathwik.prod_ready_features.advices.ApiResponse;
import com.codingshuttle.sathwik.prod_ready_features.clients.EmployeeClient;
import com.codingshuttle.sathwik.prod_ready_features.dto.EmployeeDTO;
import com.codingshuttle.sathwik.prod_ready_features.exceptions.RescourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@RequiredArgsConstructor

@Service
public class EmployeeClientImpl implements EmployeeClient {

    Logger logger = LoggerFactory.getLogger(EmployeeClientImpl.class);

    private final RestClient restClient;


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        try{
            logger.info("Get all employees started");
            logger.warn("Get all employees started so you might get Database error");
            logger.debug("Get all employees started so you might get Database error DEBUG");
            logger.trace("Get all employees started so you might get Database error TRACE");
            ApiResponse<List<EmployeeDTO>> employeeDTOList =restClient.get()
                    .uri("employees")
                    .retrieve()
                    .onStatus(HttpStatusCode::is5xxServerError,(req,res)->{
                        throw new RescourceNotFoundException("could not find employee list");
                    })
                    .body(new ParameterizedTypeReference<ApiResponse<List<EmployeeDTO>>>() {
                    });
            assert employeeDTOList != null;
            System.out.println(employeeDTOList.getData());
            logger.info("Get all employees completed");

            return employeeDTOList.getData();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
