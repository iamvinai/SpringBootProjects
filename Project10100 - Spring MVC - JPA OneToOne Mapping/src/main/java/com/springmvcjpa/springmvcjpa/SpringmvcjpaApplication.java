package com.springmvcjpa.springmvcjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springmvcjpa.springmvcjpa.DAO.AppDao;
import com.springmvcjpa.springmvcjpa.entities.Instructor;
import com.springmvcjpa.springmvcjpa.entities.InstructorDetail;

@SpringBootApplication
public class SpringmvcjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcjpaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runneer->{
			//createInstructor(appDao);
			findInstructor(appDao);
			//deleteInstructorById(appDao);
			//findInstructorDetail(appDao);
			//deleteInstrcutorDetailByID(appDao);
		};
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
		int theId=2;
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
