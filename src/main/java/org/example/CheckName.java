package org.example;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckName implements ConstraintValidator<Name, String>  {
    @Override
    public void initialize(Name constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.equals("Ivan");
    }

}

