package com.codingshuttle.sathwik.SecurityApplication.configs;

import com.codingshuttle.sathwik.SecurityApplication.filters.JWTAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.security.authorization.AuthorizationManagers;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import org.springframework.http.HttpMethod;

import jakarta.servlet.http.HttpServletResponse;

import static com.codingshuttle.sathwik.SecurityApplication.dto.Permission.*;
import static com.codingshuttle.sathwik.SecurityApplication.dto.enums.Role.ADMIN;
import static com.codingshuttle.sathwik.SecurityApplication.dto.enums.Role.USER;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JWTAuthFilter jwtAuthFilter;

    private  static  final String[] publicRoutes={
            "/auth/**", "/error","/home.html"
    };

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers(publicRoutes).permitAll()
                    .requestMatchers(HttpMethod.GET,"/posts", "/posts/**")
                        .hasAuthority(POST_VIEW.name())
                    .requestMatchers(HttpMethod.POST, "/posts", "/posts/**")
                            .access(AuthorizationManagers.allOf(
                                    AuthorityAuthorizationManager.hasAnyRole(
                                            ADMIN.name(),
                                            USER.name()
                                    ),
                                    AuthorityAuthorizationManager.hasAuthority(POST_CREATE.name()),
                                    AuthorityAuthorizationManager.hasAuthority(POST_VIEW.name())
                            ))

                .anyRequest().authenticated())
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessionConfig -> sessionConfig
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exHandling -> exHandling
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                            response.setContentType("application/json");
                            response.getWriter().write("{\"error\": \"Access Denied: You do not have permission to access this resource\", \"statusCode\": \"FORBIDDEN\"}");
                        })
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);


        return httpSecurity.build();

    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return  config.getAuthenticationManager();
    }




}
