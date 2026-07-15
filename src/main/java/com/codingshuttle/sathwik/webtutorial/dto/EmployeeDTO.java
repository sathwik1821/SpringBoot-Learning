package com.codingshuttle.sathwik.webtutorial.dto;

import com.codingshuttle.sathwik.webtutorial.annotations.EmployeeAgeValidation;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class EmployeeDTO {

    private Long ID;
    @NotNull(message = "name must be specified")
    private String name;
    private  String email;
    @EmployeeAgeValidation
    private  Integer age;
    private LocalDate dateOfJoining;
    private Boolean isActive;

    public EmployeeDTO(){

    }

    public EmployeeDTO(Long ID, String name, String email, Integer age, LocalDate dateOfJoining, Boolean isActive) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }

}
