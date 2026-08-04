package com.codingfshuttle.sathwik.hospitalManagementSystem.services;

import com.codingfshuttle.sathwik.hospitalManagementSystem.entites.Insurance;
import com.codingfshuttle.sathwik.hospitalManagementSystem.entites.Patient;
import com.codingfshuttle.sathwik.hospitalManagementSystem.repositories.InsuranceRepository;
import com.codingfshuttle.sathwik.hospitalManagementSystem.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;

    @Transactional
    public void assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance); // dirty patient

        insurance.setPatient(patient); //optional,
    }

    @Transactional
    public Insurance updateInsuranceOfAPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance); // dirty patient

        insurance.setPatient(patient); //optional,
        return insurance;
    }

    @Transactional
    public Patient removeInsuranceOfAPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(null); // dirty patient

        return patient;
    }
}
