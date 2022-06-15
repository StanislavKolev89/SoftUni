package com.example.moblilelele.model.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidEmalValidatior.class)
@Target(  ElementType.FIELD )
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidEmail {
    String message() default "Username already taken.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
