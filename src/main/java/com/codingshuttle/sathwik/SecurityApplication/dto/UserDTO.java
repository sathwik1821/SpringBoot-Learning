package com.codingshuttle.sathwik.SecurityApplication.dto;

import com.codingshuttle.sathwik.SecurityApplication.dto.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String name;
    private Set<Role> roles;
}
