package com.springmvcjpa.springmvcjpa.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvcjpa.springmvcjpa.entities.Course;
import com.springmvcjpa.springmvcjpa.entities.Instructor;
import com.springmvcjpa.springmvcjpa.entities.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppDaoImpl implements AppDao {

    private EntityManager theEntityManager;

    public AppDaoImpl(EntityManager theEntityManager){
        this.theEntityManager = theEntityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theinstructor) {
        theEntityManager.persist(theinstructor);
    }
    @Override
    public Instructor findInstructorById(int id) {
        return theEntityManager.find(Instructor.class, id);
    }
    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor tempInstructor = findInstructorById(id);
        theEntityManager.remove(tempInstructor);
    }
    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        InstructorDetail theInstructorDetail = theEntityManager.find(InstructorDetail.class, id);
        return theInstructorDetail;
    }
    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail tempInstructorDetail = findInstructorDetailById(id);
        tempInstructorDetail.getInstructor().setInstructorDetail(null);
        theEntityManager.remove(tempInstructorDetail);
    }
    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course>query = theEntityManager.createQuery("from Course WHERE instructor.id=:theId", Course.class);
        query.setParameter("theId", id);
        List<Course> courses = query.getResultList();
        return courses;

        }
    
}
