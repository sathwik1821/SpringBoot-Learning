package com.codingshuttle.sathwik.webtutorial.annotations;

import com.codingshuttle.sathwik.webtutorial.dto.EmployeeDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Valid;

public class EmployeeAgeValidator implements ConstraintValidator<EmployeeAgeValidation, Integer> {

    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
        return age >= 18;
    }
}
