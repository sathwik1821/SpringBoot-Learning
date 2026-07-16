package com.codingshuttle.sathwik.webtutorial.services;

import com.codingshuttle.sathwik.webtutorial.dto.EmployeeDTO;
import com.codingshuttle.sathwik.webtutorial.entities.EmployeeEntity;
import com.codingshuttle.sathwik.webtutorial.repositiries.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.Map;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> findById(Long employeeID) {

        return employeeRepository.findById(employeeID)
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));
    }



    public List<EmployeeDTO> findAll() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }



    public EmployeeDTO save(EmployeeDTO inputEmployee) {
        EmployeeEntity employeeEntity =
                employeeRepository.save(modelMapper.map(inputEmployee, EmployeeEntity.class));

        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }



    public EmployeeDTO updateEmployee(Long employeeID, EmployeeDTO updateEmployee) {

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeID).orElse(null);
        if (employeeEntity == null) {
            return null;
        }
        updateEmployee.setID(employeeID);
        employeeEntity = employeeRepository.save(
                modelMapper.map(updateEmployee, EmployeeEntity.class)
        );
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }




    public boolean deleteEmployee(Long employeeID) {

        boolean flag = employeeRepository.existsById(employeeID);
        if (!flag) {
            return false;
        }
        employeeRepository.deleteById(employeeID);
        return true;
    }




    public EmployeeDTO partialUpdateEmployee(Long employeeID, Map<String, Object> updates) {

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeID).orElse(null);
        if (employeeEntity == null) {
            return null;
        }

        updates.forEach((field, value) -> {

            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);

            if (fieldToBeUpdated != null) {
                fieldToBeUpdated.setAccessible(true);
                ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
            }
        });

        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }
}