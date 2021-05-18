package ru.itis.antonov.imagination.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HasLettersValidator implements ConstraintValidator<HasLetters, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches(".*[a-zA-Z].*");
    }
}
