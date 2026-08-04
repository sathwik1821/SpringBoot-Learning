package com.codingfshuttle.sathwik.hospitalManagementSystem.services;


import com.codingfshuttle.sathwik.hospitalManagementSystem.entites.Appointment;
import com.codingfshuttle.sathwik.hospitalManagementSystem.entites.Doctor;
import com.codingfshuttle.sathwik.hospitalManagementSystem.entites.Patient;
import com.codingfshuttle.sathwik.hospitalManagementSystem.repositories.AppointmentRepository;
import com.codingfshuttle.sathwik.hospitalManagementSystem.repositories.DoctorRepository;
import com.codingfshuttle.sathwik.hospitalManagementSystem.repositories.InsuranceRepository;
import com.codingfshuttle.sathwik.hospitalManagementSystem.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public void createANewAppointment(Appointment appointment, Long patientId, Long doctorId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);
    }
}
