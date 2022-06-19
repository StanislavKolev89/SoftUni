package com.example.battleship.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = EmailExistingValidator.class)
public @interface EmailExisting {

    String message() default "Email already exists.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
