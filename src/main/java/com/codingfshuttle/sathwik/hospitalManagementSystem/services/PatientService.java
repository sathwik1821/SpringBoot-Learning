package com.codingfshuttle.sathwik.hospitalManagementSystem.services;

import com.codingfshuttle.sathwik.hospitalManagementSystem.entites.Insurance;
import com.codingfshuttle.sathwik.hospitalManagementSystem.entites.Patient;
import com.codingfshuttle.sathwik.hospitalManagementSystem.repositories.InsuranceRepository;
import com.codingfshuttle.sathwik.hospitalManagementSystem.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public void testPatientTransaction() {

        Patient p1 = patientRepository.findById(1L).orElseThrow();
        Patient p2 = patientRepository.findById(1L).orElseThrow();

        System.out.println(p1 +"  "+p2);
        System.out.println(p1 == p2);

        p1.setName("Random Name");
    }

    @Transactional
    public void deletePatient(Long patientId) {
        patientRepository.findById(patientId).orElseThrow();
        patientRepository.deleteById(patientId);
    }

}
