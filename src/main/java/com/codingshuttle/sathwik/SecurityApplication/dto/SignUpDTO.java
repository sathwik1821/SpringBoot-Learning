package com.codingshuttle.sathwik.SecurityApplication.dto;

import com.codingshuttle.sathwik.SecurityApplication.dto.enums.Role;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpDTO {
    private String email;
    private String password;
    private String name;

    private Set<Role> roles;
}
