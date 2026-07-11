package com.codingshuttle.sathwik.webtutorial.controllers;

import com.codingshuttle.sathwik.webtutorial.dto.EmployeeDTO;
import com.codingshuttle.sathwik.webtutorial.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/{employeeID}")
    public ResponseEntity<EmployeeDTO> getEmployeeByID(@PathVariable Long employeeID){
        EmployeeDTO employee = employeeService.findById(employeeID);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }


    @GetMapping
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.findAll();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee (@RequestBody EmployeeDTO inputEmployee) {

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
