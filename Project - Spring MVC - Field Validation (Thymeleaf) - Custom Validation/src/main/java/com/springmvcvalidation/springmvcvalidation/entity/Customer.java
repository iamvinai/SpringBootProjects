package com.springmvcvalidation.springmvcvalidation.entity;


import com.springmvcvalidation.springmvcvalidation.validation.CourseCode;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {

    private String firstName;

    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName = "";
    @NotNull(message="is required")
    @Min(value=0,message="must be greater than equal to 0")
    @Max(value=10,message ="must be less than or equal to 10")
    private Integer freePasses;
    @Pattern(regexp="^[a-zA-Z0-9]{5}",message="only 5 characters which are chars/digits must be entered")
    private String postalCode;
    @NotNull(message="Value should not be null")
    @CourseCode(value = "COSC",message = "Course Code starts with COSC")
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
    public Integer getFreePasses() {
        return this.freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getCourseCode() {
        return this.courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }



}