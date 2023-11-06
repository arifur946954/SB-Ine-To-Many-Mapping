package com.jpa.JpaCrud;

import com.jpa.JpaCrud.dao.AppDao;
import com.jpa.JpaCrud.entity.Course;
import com.jpa.JpaCrud.entity.Instructor;
import com.jpa.JpaCrud.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaCrudApplication {
	//this is test

	public static void main(String[] args) {
		SpringApplication.run(JpaCrudApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return  runner->{
		//createConstructor(appDao);
			//findInstructor(appDao);
			//deleteInstructor(appDao);
			//findInstructorDetails(appDao);
			//deleteInstructorDetails(appDao);
			//createInstructorWithCourse(appDao);
			findInstructorWithCourses(appDao);
			//test file
		};
	}

	private void findInstructorWithCourses(AppDao appDao) {
		int theId=1;
		Instructor tempIns= appDao.findInstructorById(theId);
		System.out.println("temp instructor is: "+tempIns);
		System.out.println("course is"+tempIns.getCourses());
		System.out.println("done!!!!!!");
	}

	private void createInstructorWithCourse(AppDao appDao) {
		Instructor tempInstructor=new Instructor("Test9","Rahman","test9@gmail.com");
		InstructorDetails tempInstructorDetails=new InstructorDetails("test9@youtube.com","swimming");
		tempInstructor.setInstructorDetails(tempInstructorDetails);
		Course course1=new Course("CSE-801");
		Course course2=new Course("CSE-802");
		Course course3=new Course("CSE-803");
		//associate the obj
		tempInstructor.add(course1);
		tempInstructor.add(course2);
		tempInstructor.add(course3);
		appDao.save(tempInstructor);


		System.out.println(tempInstructor);
		tempInstructor.setInstructorDetails(tempInstructorDetails);
		appDao.save(tempInstructor);


		System.out.println("done");


	}

	private void deleteInstructorDetails(AppDao appDao) {
		int theId=1;
		appDao.deleteInstructorDetails(theId);
	}

	private void findInstructorDetails(AppDao appDao) {
		int theId=1;
	InstructorDetails tempInatructorsDetails=	appDao.findInstructoDetailsById(theId);
		System.out.println(tempInatructorsDetails);
		//System.out.println(tempInatructorsDetails.getInstructor());

	}

	private void deleteInstructor(AppDao appDao) {
		int theId=1;
		appDao.deleteInstructorById(theId);
	}

	private void findInstructor(AppDao appDao) {
		int theId=2;
	Instructor tempInsTructor=	appDao.findInstructorById(theId);
		System.out.println(tempInsTructor);
		//System.out.println("instructor detils is: "+tempInsTructor.getInstructorDetails());
	}

	private void createConstructor(AppDao appDao) {
		Instructor tempInstructor=new Instructor("Test1","Rahman","test5@gmail.com");
		InstructorDetails tempInstructorDetails=new InstructorDetails("test1@youtube.com","swimming");
		//associate the obj
		tempInstructor.setInstructorDetails(tempInstructorDetails);
		System.out.println(tempInstructor);
		appDao.save(tempInstructor);


		System.out.println("done");
		//save the instructor details
	}

}
