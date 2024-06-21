package com.springboot.jpacrud;


import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.jpacrud.dao.StudentDAO;
import com.springboot.jpacrud.entity.Student;

@SpringBootApplication
public class JpacrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpacrudApplication.class, args);
	}
	@Bean 
		public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
			return runner->{
				//createStudent(studentDAO);
				//creatsMultipleStudents(studentDAO);
				//readStudent(studentDAO);
				//queryForStudents(studentDAO);
				//queryForStudentsByLastName(studentDAO);
				//updateStudentFirstName(studentDAO);
				deleteStudent(studentDAO);
				//deleteAllStudents(studentDAO);
			};
		}
	private void deleteAllStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		studentDAO.deleteAll();
	}
	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=7;
		studentDAO.delete(studentId);
	}
	private void updateStudentFirstName(StudentDAO studentDAO) {
		int studentId = 14;
		Student myStudent = studentDAO.findById(studentId);
		System.out.println(myStudent);
		myStudent.setFirstName("Virat");
		studentDAO.update(myStudent);

	}
	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Bumra");
		for(Student tempStudent: students){
			System.out.println(tempStudent.getId());
			System.out.println(tempStudent.getFirstName());
			System.out.println(tempStudent.getLastName());
			System.out.println(tempStudent.getEmail());
		}
	}
	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for(Student tempStudent:students){
			System.out.println(tempStudent.getId()+" "+tempStudent.getFirstName()+" "+tempStudent.getLastName());
		}
	}
	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent4 = new Student("Sachin","Tendulkar","sachin10@gmail.com");
		studentDAO.save(tempStudent4);
		System.out.println("Saved Student Id: "+tempStudent4.getId());
		int theId=tempStudent4.getId();
		Student myStudent = studentDAO.findById(theId);
		System.out.println(myStudent.getId());
		System.out.println(myStudent.getFirstName());
		System.out.println(myStudent.getLastName());
	}
	private void creatsMultipleStudents(StudentDAO studentDAO) {
		Student tempStudent1 = new Student("Dhoni","Mahendra","dhone7@gmail.com");
		Student tempStudent2 = new Student("Rohit","sharma","rohitsharma45@gmail.com");
		Student tempStudent3 = new Student("Jasprit","Bumra","jbumra1@gmail.com");
		studentDAO.save(tempStudent1); // Save the student 
		studentDAO.save(tempStudent2); // Save the student 
		studentDAO.save(tempStudent3); // Save the student 
	}
	private void createStudent(StudentDAO studentDAO) {
		//create the student Object

		Student tempStudent = new Student("Virat","Kohli","viratkohli18@gmail.com");
		studentDAO.save(tempStudent); // Save the student 
		System.out.println("Student ID: "+tempStudent.getId()); 

	}

}
