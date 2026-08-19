package com.codingshuttle.sathwik.SecurityApplication;

import com.codingshuttle.sathwik.SecurityApplication.entities.User;
import com.codingshuttle.sathwik.SecurityApplication.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtServiceTests {


    @Autowired
    private JwtService jwtService;

    @Test
    void getUserDetails() {
        User user=new User(18L,"sathwik@gmail.com","sathwik@18","sathwik", java.util.Set.of());

        String token=jwtService.generateAccessToken(user);
        System.out.println(token);

        Long id=jwtService.getUserIdFromToken(token);
        System.out.println(id);
    }
}
