package com.codingfshuttle.sathwik.hospitalManagementSystem.repositories;

import com.codingfshuttle.sathwik.hospitalManagementSystem.dto.BloodGroupStats;
import com.codingfshuttle.sathwik.hospitalManagementSystem.dto.CPatientInfo;
import com.codingfshuttle.sathwik.hospitalManagementSystem.dto.IPatientInfo;
import com.codingfshuttle.sathwik.hospitalManagementSystem.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p.id as id, p.name as name, p.email as email from Patient p")
    List<IPatientInfo> getAllPatientsInfo();

    @Query("""
    select new com.codingfshuttle.sathwik.hospitalManagementSystem.dto.CPatientInfo(p.id,p.name)from Patient p\s
       \s""")
    List<CPatientInfo> getAllPatientsInfoConcrete();

    @Query("""
    SELECT new com.codingfshuttle.sathwik.hospitalManagementSystem.dto.BloodGroupStats(
        p.bloodGroup,
        COUNT(p)
    )
    FROM Patient p
    GROUP BY p.bloodGroup
    ORDER BY COUNT(p) DESC
    """)
    List<BloodGroupStats> getBloodGroupStats();
}
