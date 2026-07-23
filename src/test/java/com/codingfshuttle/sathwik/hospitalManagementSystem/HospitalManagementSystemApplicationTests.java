package com.codingfshuttle.sathwik.hospitalManagementSystem;

import com.codingfshuttle.sathwik.hospitalManagementSystem.dto.BloodGroupStats;
import com.codingfshuttle.sathwik.hospitalManagementSystem.dto.CPatientInfo;
import com.codingfshuttle.sathwik.hospitalManagementSystem.dto.IPatientInfo;
import com.codingfshuttle.sathwik.hospitalManagementSystem.entites.Patient;
import com.codingfshuttle.sathwik.hospitalManagementSystem.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.TimeZone;

@SpringBootTest
class HospitalManagementSystemApplicationTests {

	static {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
	}

	@Autowired
	private PatientRepository patientRepository;

	@Test
	void testPatient() {

		//test where we dont use any projection
		List<Patient> patientList = patientRepository.findAll();

		//test where we use interface type DTO projection
		List<IPatientInfo> patientListInterfaceList= patientRepository.getAllPatientsInfo();

		//test where we use class type DTO projection
		List<CPatientInfo> patientInfoConcreteList=patientRepository.getAllPatientsInfoConcrete();

		//test where we use dto for aggregate results
		List<BloodGroupStats> bloodGroupStatsList=patientRepository.getBloodGroupStats();

		for (BloodGroupStats p : bloodGroupStatsList) {
			System.out.println(p.getBloodGroupType() + " - " + p.getCount());
		}
	}



}
