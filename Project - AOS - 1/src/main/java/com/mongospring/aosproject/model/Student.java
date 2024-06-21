package com.mongospring.aosproject.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student {
    private String Name;
    private String University;
    private String Course;

    public Student() {
    }
    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getUniversity() {
        return this.University;
    }

    public void setUniversity(String University) {
        this.University = University;
    }

    public String getCourse() {
        return this.Course;
    }

    public void setCourse(String Course) {
        this.Course = Course;
    }

    @Override
    public String toString() {
        return "{" +
            " Name='" + getName() + "'" +
            ", University='" + getUniversity() + "'" +
            ", Course='" + getCourse() + "'" +
            "}";
    }


}
