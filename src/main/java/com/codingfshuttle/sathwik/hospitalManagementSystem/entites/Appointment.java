package com.codingfshuttle.sathwik.hospitalManagementSystem.entites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    @ManyToOne //owning side
    @JoinColumn(nullable = false)
    private Patient patient;

    @ManyToOne //owning side
    @JoinColumn(nullable = false)
    private Doctor doctor;

}
