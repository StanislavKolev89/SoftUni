package com.example.moblilelele.model.validation;

import com.example.moblilelele.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidEmailValidatior implements ConstraintValidator<ValidEmail, String> {

    private final UserRepository userRepository;

    public ValidEmailValidatior(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void initialize(ValidEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return userRepository.findByEmail(value).isEmpty();
    }
}
