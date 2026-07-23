package com.codingfshuttle.sathwik.hospitalManagementSystem.dto;

import com.codingfshuttle.sathwik.hospitalManagementSystem.entites.type.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroupType bloodGroupType;
    private final Long count;
}
