package com.springboot.jpacrud.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.springboot.jpacrud.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define field for entity manager
    private EntityManager entityManager;
    //inject entity manager using constructor injection
  
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }
    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theTypedQuery = entityManager.createQuery("FROM Student ORDER BY lastName asc",Student.class);
        return theTypedQuery.getResultList();
    }
    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theTypedQuery = entityManager.createQuery(
            "From Student WHERE lastName=:theData",Student.class);
            theTypedQuery.setParameter("theData", lastName);
            return theTypedQuery.getResultList();
    }
    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }
    @Override
    @Transactional
    public void delete(Integer id) {

        Student theStudent = entityManager.find(Student.class,id);
        System.out.println(entityManager.toString());
        if(entityManager.contains(theStudent)){
            entityManager.remove(theStudent);
        }
        
        
    }
    @Override
    @Transactional
    public int deleteAll() {
        
        int deletedRows = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return deletedRows;
    }
    

}
