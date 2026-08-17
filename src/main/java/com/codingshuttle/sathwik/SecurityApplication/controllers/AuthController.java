package com.codingshuttle.sathwik.SecurityApplication.controllers;


import com.codingshuttle.sathwik.SecurityApplication.dto.LoginDTO;
import com.codingshuttle.sathwik.SecurityApplication.dto.SignUpDTO;
import com.codingshuttle.sathwik.SecurityApplication.dto.UserDTO;
import com.codingshuttle.sathwik.SecurityApplication.services.AuthService;
import com.codingshuttle.sathwik.SecurityApplication.services.JwtService;
import com.codingshuttle.sathwik.SecurityApplication.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping(path = "/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody SignUpDTO signUpDTO) {

        UserDTO userDTO = userService.signUp(signUpDTO);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        String token=authService.login(loginDTO);
        return ResponseEntity.ok(token);
    }
}
