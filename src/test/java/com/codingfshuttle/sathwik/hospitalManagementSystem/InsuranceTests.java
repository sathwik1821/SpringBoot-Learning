package com.codingfshuttle.sathwik.hospitalManagementSystem;

import com.codingfshuttle.sathwik.hospitalManagementSystem.entites.Insurance;
import com.codingfshuttle.sathwik.hospitalManagementSystem.services.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.TimeZone;

@SpringBootTest
public class InsuranceTests {

    static {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
    }

    @Autowired
    private  InsuranceService insuranceService;

    @Test
    public void testToAssignInsurance() {
        Insurance insurance = Insurance.builder()
                .provider("HDFC Ergo")
                .policyNumber("HDFC_23G")
                .validUntil(LocalDate.of(2030, 1, 1))
                .build();

        insuranceService.assignInsuranceToPatient(insurance,1L);
    }
}
