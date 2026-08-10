package com.codingshuttle.sathwik.prod_ready_features.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long ID;
    private String name;
    private  String email;
    private  Integer age;
    private LocalDate dateOfJoining;
    private Boolean isActive;

}
