package com.codingshuttle.sathwik.SecurityApplication.services;

import com.codingshuttle.sathwik.SecurityApplication.dto.LoginDTO;
import com.codingshuttle.sathwik.SecurityApplication.dto.LoginResponseDTO;
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
    private final UserService userService;
    private final SessionService sessionService;

    public LoginResponseDTO login(LoginDTO loginDTO) {
        Authentication authentication=authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));


        User user= (User) authentication.getPrincipal();

        assert user != null;
        String accessToken= jwtService.generateAccessToken(user);
        String refreshToken= jwtService.generateRefreshToken(user);
        sessionService.generateNewSession(user,refreshToken);

        return  new LoginResponseDTO(user.getId(),accessToken,refreshToken);
    }

    public LoginResponseDTO refreshToken(String refreshToken) {
        Long userId=jwtService.getUserIdFromToken(refreshToken);

        sessionService.validateSession(refreshToken);

        User user=userService.getUserByUserId(userId);
        String accessToken= jwtService.generateAccessToken(user);

        return  new LoginResponseDTO(userId,accessToken,refreshToken);
    }
}
