package com.codingfshuttle.sathwik.hospitalManagementSystem.entites;


import com.codingfshuttle.sathwik.hospitalManagementSystem.entites.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthDate;

    private String email;

    private String gender;

    @Enumerated(value = EnumType.STRING)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne //owning side
    @JoinColumn(name = "patient_insurance", unique = true)
    private Insurance insurance;

    @OneToMany(mappedBy = "patient") //inverse side
    private Set<Appointment> appointments=new HashSet<>();

}
