package com.aim2code.springdemo.mvc.validationdemo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    private String courseCode;
    @Override
    public void initialize(CourseCode courseCode) {
        this.courseCode = courseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

        boolean result=false;

        if(theCode==null || theCode.isEmpty()){
            result=true;
        }
        else {
            result = theCode.startsWith(courseCode);
        }

        return result;
    }

}
