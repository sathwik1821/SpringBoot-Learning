package com.codingfshuttle.sathwik.hospitalManagementSystem.repositories;

import com.codingfshuttle.sathwik.hospitalManagementSystem.entites.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}