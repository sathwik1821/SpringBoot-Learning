package com.codingshuttle.sathwik.webtutorial.controllers;

import com.codingshuttle.sathwik.webtutorial.dto.EmployeeDTO;
import com.codingshuttle.sathwik.webtutorial.exceptions.ResourceNotFoundException;
import com.codingshuttle.sathwik.webtutorial.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/{employeeID}")
    public ResponseEntity<EmployeeDTO> getEmployeeByID(@PathVariable Long employeeID){
        Optional<EmployeeDTO> employeeDTO = employeeService.findById(employeeID);

        return employeeDTO
                .map(ResponseEntity::ok)
                .orElseThrow(()->new ResourceNotFoundException("Employee with the ID " + employeeID + " does not exist"));
    }




    @GetMapping
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.findAll();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee (@RequestBody @Valid EmployeeDTO inputEmployee) {

        return employeeService.save(inputEmployee);
    }

    @PutMapping(path="/{employeeID}")
    public EmployeeDTO updateEmployee(@PathVariable Long employeeID, @RequestBody EmployeeDTO inputEmployee) {
        return employeeService.updateEmployee(employeeID,inputEmployee);
    }

    @DeleteMapping(path="/{employeeID}")
    public boolean deleteEmployee(@PathVariable Long employeeID){
        return employeeService.deleteEmployee(employeeID);
    }


    @PatchMapping(path="/{employeeID}")
    public EmployeeDTO partialUpdateEmployee(@PathVariable Long employeeID, @RequestBody Map<String, Object> updates) {
        return employeeService.partialUpdateEmployee(employeeID,updates);
    }


    @GetMapping(path="/secretMessage")
    public String secretMessage(){
        return "Hello Sir, welcome to RAW Department.";
    }

    @GetMapping(path="/")
    public String headDep(@RequestParam(required = false ,name="dep") String headDep){
        return "Welcome to RAW head Department,You have all information accessible.";
    }
}
