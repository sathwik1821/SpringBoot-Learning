package com.codingshuttle.sathwik.webtutorial.advices;


import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiError {
    HttpStatus status;
    String message;
}
