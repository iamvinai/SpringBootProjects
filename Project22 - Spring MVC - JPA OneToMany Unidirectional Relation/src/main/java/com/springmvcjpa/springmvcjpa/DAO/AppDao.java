package com.springmvcjpa.springmvcjpa.DAO;

import java.util.List;

import com.springmvcjpa.springmvcjpa.entities.Course;
import com.springmvcjpa.springmvcjpa.entities.Instructor;
import com.springmvcjpa.springmvcjpa.entities.InstructorDetail;

public interface AppDao {

    void save(Instructor theinstructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByJoinFetch(int id);
    void updateInstructor(Instructor tempInstructor);
    void updateCourse(Course course);
    Course findCourseById(int id);
    void deleteCourse(int id);
    void saveCourse(Course theCourse);
    Course findCourseAndReviewsByCourseId(int id);

}
