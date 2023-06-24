package com.hibernateAdvance.hibernateAdvance;

import com.hibernateAdvance.hibernateAdvance.dao.AppDAO;
import com.hibernateAdvance.hibernateAdvance.entity.Course;
import com.hibernateAdvance.hibernateAdvance.entity.Instructor;
import com.hibernateAdvance.hibernateAdvance.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateAdvanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateAdvanceApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){ // When Spring Loaded this method will execute.
		return runner -> {
			 addCourse(appDAO);
//			findInstrucorDetailById(appDAO);
//			deleteInstructorDetailById(appDAO);
//			 createInstructor(appDAO);

			fetchInstructorById(appDAO);
//			findCourseById(appDAO);
		};
	}

	public void findCourseById(AppDAO appDAO){
		Course couse = appDAO.findCoursById(1);
		System.out.println(couse.getInstructor());
	}
	public void fetchInstructorById(AppDAO appDAO){
		Instructor instructorFromDB = appDAO.findById(3);
		System.out.println(instructorFromDB);
	}


	public void addCourse(AppDAO appDAO){
//		String courseName, String courseDesc, String courseAddress, Instructor instructor
		Instructor tempInstructor = appDAO.findById(3);
		Course course = new Course("Java SEs", "A-Z Java SEsdasdasd", "udadasdemy", tempInstructor);
		appDAO.addCourse(course);
		System.out.println("Added new Course");
	}

	public void deleteInstructorDetailById(AppDAO appDAO){
		appDAO.deleteInstructorDetailById(2);
		System.out.println("DELETED InstructorDetail by id=" + 2);

	}

	public void findInstrucorDetailById(AppDAO appDAO){
		InstructorDetail instructorDetailFromDB = appDAO.findInstructorDetailById(2);

		System.out.println(instructorDetailFromDB);
	}

	public void deleteInstructor(AppDAO appDAO){

		appDAO.delete(1);
		System.out.println("DELETED!");
	}

	public void findInstructor(AppDAO appDAO){
		Instructor instructorFromDB = appDAO.findById(3);
		System.out.println(instructorFromDB);

	}

	public void createInstructor(AppDAO appDAO){
		Instructor tempInstructor = new Instructor("Murad", "Guliyev", "quliyev.murad@yahoo.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://luv2code.com/youtube",
				"Luv 2 code!!!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		appDAO.save(tempInstructor);

		System.out.println("Finished!");
	}

}
