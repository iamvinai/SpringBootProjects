package com.springmvcjpa.springmvcjpa;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springmvcjpa.springmvcjpa.DAO.AppDao;
import com.springmvcjpa.springmvcjpa.entities.Course;
import com.springmvcjpa.springmvcjpa.entities.Instructor;
import com.springmvcjpa.springmvcjpa.entities.InstructorDetail;
import com.springmvcjpa.springmvcjpa.entities.Review;

@SpringBootApplication
public class SpringmvcjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcjpaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runneer->{
			//deleteCourseAndReviews(appDao);
			//retriveCourseAndReviews(appDao);
			//createCourseAndReviews(appDao);
		};
	}
	@SuppressWarnings("unused")
	private void deleteCourseAndReviews(AppDao appDao) {
		int theId=12;
		appDao.deleteCourse(theId);
	}
	@SuppressWarnings("unused")
	private void retriveCourseAndReviews(AppDao appDao) {
		int theId=12;
		Course tempCourse = appDao.findCourseAndReviewsByCourseId(theId);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
	}
	@SuppressWarnings("unused")
	private void createCourseAndReviews(AppDao appDao) {
		Course tempCourse = new Course("Pacman - How to score a million points");
		tempCourse.addReview(new Review("Nice course!"));
		tempCourse.addReview(new Review("Cool Course!"));
		tempCourse.addReview(new Review("The Course could be better!"));
		appDao.saveCourse(tempCourse);
	}
	@SuppressWarnings("unused")
	private void deleteCourse(AppDao appDao) {
		int cid = 10;
		appDao.deleteCourse(cid);
	}
	@SuppressWarnings("unused")
	private void updateCourse(AppDao appDao) {
		int theId=10;
		Course tempCourse = appDao.findCourseById(theId);
		tempCourse.setTitle("Deep Learning");
		appDao.updateCourse(tempCourse);
	}
	@SuppressWarnings("unused")
	private void updateInstructor(AppDao appDao) {
		int theId=1;
		Instructor tempInstructor = appDao.findInstructorById(theId);
		tempInstructor.setLastName("TESTER");
		appDao.updateInstructor(tempInstructor)	;
	}
	@SuppressWarnings("unused")
	private void findInstructorwithCoursesJoinFetch(AppDao appDao) {
		int theId=1;
		Instructor theInstructor = appDao.findInstructorByJoinFetch(theId);
		System.out.println("Instructor's'courses "+theInstructor.getCourses());
		System.out.println("Instructor Detail "+theInstructor.getInstructorDetail());
	}
	@SuppressWarnings("unused")
	private void findCoursesForInstructor(AppDao appDao) {
		int theId=1;
		Instructor theInstructor = appDao.findInstructorById(theId);
		List<Course>courses = appDao.findCoursesByInstructorId(theInstructor.getId());
		theInstructor.setCourses(courses);
		System.out.println(theInstructor.getCourses());
	}
	@SuppressWarnings("unused")
	private void findInstructorWithCourses(AppDao appDao) {
		int theId=1;
		Instructor theInstructor = appDao.findInstructorById(theId);
		System.out.println(theInstructor.getCourses());
	}
	@SuppressWarnings("unused")
	private void createInstructorWithCourses(AppDao appDao) {
		Instructor tempInstructor = new Instructor("Hardik","Pandya","hp@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/hpandya","Rugby");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		Course tempCourse1 = new Course("Data Science");
		Course tempCourse2 = new Course("Machine Learning");
		tempInstructor.addCourse(tempCourse1);
		tempInstructor.addCourse(tempCourse2);
		appDao.save(tempInstructor);
		
	}
	@SuppressWarnings("unused")
	private void deleteInstrcutorDetailByID(AppDao appDao) {
		int theId =1;
		appDao.deleteInstructorDetailById(theId);
	}
	@SuppressWarnings("unused")
	private void findInstructorDetail(AppDao appDao) {
		int theId=1;
		InstructorDetail theInstructorDetail =  appDao.findInstructorDetailById(theId);
		System.out.println(theInstructorDetail+" "+theInstructorDetail.getInstructor());

	}
	@SuppressWarnings("unused")
	private void deleteInstructorById(AppDao appDao) {
		int theId=1;
		appDao.deleteInstructorById(theId);
	}	
	@SuppressWarnings("unused")
	private void findInstructor(AppDao appDao) {
		int theID=1;
		Instructor theInstructor  = appDao.findInstructorById(theID);
		System.out.println(theInstructor);
		System.out.println(theInstructor.getInstructorDetail());
	}
	@SuppressWarnings("unused")
	private void createInstructor(AppDao theAppDao) {
		Instructor tempInstructor = new Instructor("MS","Dhoni","msd007@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com","Football");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println(tempInstructor);
		theAppDao.save(tempInstructor);

	}

}
