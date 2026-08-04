package com.codingfshuttle.sathwik.hospitalManagementSystem;

import com.codingfshuttle.sathwik.hospitalManagementSystem.entites.Appointment;
import com.codingfshuttle.sathwik.hospitalManagementSystem.services.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.TimeZone;

@SpringBootTest
public class AppointmentTests {

    static {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
    }


    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testToCreateAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 11, 1, 14, 0, 0))
                .reason("Cancer")
                .build();

        appointmentService.createANewAppointment(appointment,1L,2L);
    }
}
