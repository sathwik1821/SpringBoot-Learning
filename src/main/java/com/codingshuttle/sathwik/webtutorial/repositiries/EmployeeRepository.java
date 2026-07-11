package com.codingshuttle.sathwik.webtutorial.repositiries;

import com.codingshuttle.sathwik.webtutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
