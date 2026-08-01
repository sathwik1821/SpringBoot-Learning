package com.codingfshuttle.sathwik.hospitalManagementSystem.entites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @OneToOne //owning side
    @JoinColumn(nullable = false)
    private Doctor headDoctor;

    @ManyToMany //has a separate table (pk as department_id and doctor_id)
    private Set<Doctor> doctors = new HashSet<>();
}
