package com.codingfshuttle.sathwik.hospitalManagementSystem;


import com.codingfshuttle.sathwik.hospitalManagementSystem.dto.BloodGroupStats;
import com.codingfshuttle.sathwik.hospitalManagementSystem.dto.CPatientInfo;
import com.codingfshuttle.sathwik.hospitalManagementSystem.dto.IPatientInfo;
import com.codingfshuttle.sathwik.hospitalManagementSystem.entites.Patient;
import com.codingfshuttle.sathwik.hospitalManagementSystem.repositories.PatientRepository;
import com.codingfshuttle.sathwik.hospitalManagementSystem.services.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.TimeZone;

@SpringBootTest
public class PatientTests {

    static {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
    }

    @Autowired
    private PatientRepository patientRepository;
    private PatientService patientService;


    @Test
    void testPatient() {

        //test where we use class type DTO projection
        List<CPatientInfo> patientInfoConcreteList=patientRepository.getAllPatientsInfoConcrete();

        for (CPatientInfo p : patientInfoConcreteList) {
            System.out.println(p.getId() + " - " + p.getName());
        }
    }


    @Test
    void testPatientFromService() {

    }



}
