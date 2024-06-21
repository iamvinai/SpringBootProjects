package com.springboot.jpacrud.dao;

import java.util.List;

import com.springboot.jpacrud.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student student);
    void delete(Integer id);
    int deleteAll();
}
