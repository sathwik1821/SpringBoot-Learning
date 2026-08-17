package com.codingshuttle.sathwik.SecurityApplication.services;

import com.codingshuttle.sathwik.SecurityApplication.dto.LoginDTO;
import com.codingshuttle.sathwik.SecurityApplication.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public String login(LoginDTO loginDTO) {
        Authentication authentication=authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));


        User user= (User) authentication.getPrincipal();
        assert user != null;
        return "Bearer "+jwtService.generateToken(user);

    }
}
