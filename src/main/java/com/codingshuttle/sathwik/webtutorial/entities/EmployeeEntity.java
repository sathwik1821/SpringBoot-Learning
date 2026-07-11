package com.codingshuttle.sathwik.webtutorial.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "EmployeeTable")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ID;
    private String name;
    private  String email;
    private  Integer age;
    private LocalDate dateOfJoining;
    private Boolean isActive;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Long ID, String name, String email, Integer age, LocalDate dateOfJoining, Boolean isActive) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }

}
