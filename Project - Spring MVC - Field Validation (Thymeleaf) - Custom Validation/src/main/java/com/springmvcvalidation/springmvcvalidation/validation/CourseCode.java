package com.springmvcvalidation.springmvcvalidation.validation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy=CourseCodeConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //attributes
    public String value() default "vinai";
    public String message() default "must start with vinai";

    //define default groups
    public Class<?>[] groups() default{};
    public  Class<? extends Payload>[] payload() default {};
}
