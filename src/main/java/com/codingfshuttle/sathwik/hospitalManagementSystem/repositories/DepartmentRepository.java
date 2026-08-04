package com.codingfshuttle.sathwik.hospitalManagementSystem.repositories;

import com.codingfshuttle.sathwik.hospitalManagementSystem.entites.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}