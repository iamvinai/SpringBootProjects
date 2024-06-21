package com.demospringmvc.demospringmvc.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String language;
    private List<String> operatingsystems;

    public Student(){

    }
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String getLanguage() {
        return this.language;
    }


    public List<String> getOperatingsystems() {
        return this.operatingsystems;
    }

    public void setOperatingsystems(List<String> operatingsystems) {
        this.operatingsystems = operatingsystems;
    }


    public void setLanguage(String language) {
        this.language = language;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "{" +
            " firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            "}";
    }



}
