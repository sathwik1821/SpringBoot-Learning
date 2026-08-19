package com.codingshuttle.sathwik.SecurityApplication.advices;


import com.codingshuttle.sathwik.SecurityApplication.exceptions.RescourceNotFoundException;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RescourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(RescourceNotFoundException ex) {
        ApiError apiError=new ApiError(ex.getMessage(),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiError> handleJwtException(JwtException ex) {
        ApiError apiError=new ApiError(ex.getMessage(),HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(apiError,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiError> handleAuthenticationException(AuthenticationException ex) {
        ApiError apiError=new ApiError(ex.getMessage(),HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(apiError,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiError> handleAccessDeniedException(AccessDeniedException ex) {
        ApiError apiError=new ApiError("Access Denied: You do not have permission to access this resource",HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(apiError,HttpStatus.FORBIDDEN);
    }


}
