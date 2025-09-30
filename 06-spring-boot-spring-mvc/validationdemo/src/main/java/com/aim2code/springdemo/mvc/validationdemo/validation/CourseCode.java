package com.aim2code.springdemo.mvc.validationdemo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    public String value() default "aim";

    public String message() default "Text should start with aim";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
