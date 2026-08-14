package com.codingshuttle.sathwik.SecurityApplication.advices;


import com.codingshuttle.sathwik.SecurityApplication.exceptions.RescourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RescourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(RescourceNotFoundException ex) {
        ApiError apiError=new ApiError(ex.getMessage(),HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }

}
