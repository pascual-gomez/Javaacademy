package com.pascualgomez.Thesis.Annotations;

import com.pascualgomez.Thesis.DTOs.RegistrationUserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        RegistrationUserDTO user = (RegistrationUserDTO) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
