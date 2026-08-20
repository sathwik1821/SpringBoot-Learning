package com.codingshuttle.sathwik.SecurityApplication.services;

import com.codingshuttle.sathwik.SecurityApplication.dto.LoginDTO;
import com.codingshuttle.sathwik.SecurityApplication.dto.SignUpDTO;
import com.codingshuttle.sathwik.SecurityApplication.dto.UserDTO;
import com.codingshuttle.sathwik.SecurityApplication.entities.User;
import com.codingshuttle.sathwik.SecurityApplication.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codingshuttle.sathwik.SecurityApplication.dto.enums.Role;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new BadCredentialsException("User not found"));
    }

    public UserDTO signUp(SignUpDTO signUpDTO) {
        Optional<User> user = userRepository.findByEmail(signUpDTO.getEmail());

        if (user.isPresent()) {
            throw new BadCredentialsException("User already exists with username " + signUpDTO.getEmail());
        }

        User newUser = modelMapper.map(signUpDTO, User.class);
        newUser.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
        newUser.setRoles(signUpDTO.getRoles());
        newUser.setPermissions(signUpDTO.getPermissions());

        User savedUser = userRepository.save(newUser);
        return modelMapper.map(savedUser, UserDTO.class);

    }

    public User getUserByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow(() -> new BadCredentialsException("User not found"));
    }


}
