package com.aim2code.springdemo.mvc.validationdemo;

import com.aim2code.springdemo.mvc.validationdemo.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "This Field is required")
    @Size(min = 1,max = 10, message = "field is not in limit")
    private String lastName;

    @Min(value=0,message = "must be >=0")
    @Max(value=10,message="must be <=10")
    private int freePasses;

    @NotNull(message = "This Field is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "zipCode is invalid")
    private String zipCode;

    @CourseCode(value = "Vijay",message = "Text Must start With Vijay")
    private String courseCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
