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
        List<Course> courses = tempInstructor.getCourses();
        for(Course tempCourse: courses){
            tempCourse.setInstructor(null);
        }
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
        TypedQuery<Course>query = theEntityManager.createQuery(
                                                    "from Course WHERE instructor.id=:theId",
                                                    Course.class);
        query.setParameter("theId", id);
        List<Course> courses = query.getResultList();
        return courses;

        }
    @Override
    public Instructor findInstructorByJoinFetch(int id) {
        TypedQuery<Instructor> query = theEntityManager.createQuery("Select i FROM Instructor i "+
                                                                    " JOIN FETCH i.courses "+
                                                                    " JOIN FETCH i.instructorDetail "+
                                                                    " WHERE i.id =:data",
                                                                    Instructor.class); 
        query.setParameter("data", id);
        Instructor theInstructor = query.getSingleResult();
        return theInstructor;
    }
    @Override
    @Transactional
    public void updateInstructor(Instructor tempInstructor) {
        theEntityManager.merge(tempInstructor);
    }
    @Override
    @Transactional
    public void updateCourse(Course course) {
        theEntityManager.merge(course);
    }
    @Override
    public Course findCourseById(int id) {
        Course theCourse = theEntityManager.find(Course.class, id);
        return theCourse;
    }
    @Override
    @Transactional
    public void deleteCourse(int id) {
        Course tempCourse = theEntityManager.find(Course.class, id);
        theEntityManager.remove(tempCourse);
    }
    @Override
    @Transactional
    public void saveCourse(Course theCourse) {
        theEntityManager.persist(theCourse);
    }
    @Override
    public Course findCourseAndReviewsByCourseId(int id) {
        TypedQuery<Course> query = theEntityManager.createQuery("SELECT c FROM Course c "+
                                                                "JOIN FETCH c.reviews "+
                                                                "WHERE c.id=:data",
                                                                Course.class);
        query.setParameter("data", id);
        Course tempCourse = query.getSingleResult();
        return tempCourse;
    }
    
}
