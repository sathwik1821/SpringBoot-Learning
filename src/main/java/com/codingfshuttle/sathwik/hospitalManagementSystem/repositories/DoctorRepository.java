package com.codingfshuttle.sathwik.hospitalManagementSystem.repositories;

import com.codingfshuttle.sathwik.hospitalManagementSystem.entites.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}