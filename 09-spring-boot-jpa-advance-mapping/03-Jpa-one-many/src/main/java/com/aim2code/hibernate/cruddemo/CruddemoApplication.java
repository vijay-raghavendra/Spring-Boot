package com.aim2code.hibernate.cruddemo;

import com.aim2code.hibernate.cruddemo.DAO.AppDAO;
import com.aim2code.hibernate.cruddemo.entity.Course;
import com.aim2code.hibernate.cruddemo.entity.Instructor;
import com.aim2code.hibernate.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO)
    {
        return runner -> {
            //CreateOrSaveInstructor(appDAO);
            //findInstructorById(appDAO);
            //DeleteInstructorById(appDAO);
            //findInstructorDetailById(appDAO);
            //DeleteInstructorDetailsById(appDAO);
            //createInstructorWithCourse(appDAO);
            //findInstructorWithCourses(appDAO);
            //findCoursesForInstructor(appDAO);
            //findCoursesForInstructorJoinFetch(appDAO);
            UpdateInstructor(appDAO);
        };
    }

    private void UpdateInstructor(AppDAO appDAO) {
        int id=1;
        System.out.println("Finding the Instructor by ID : ");
        Instructor instructor = appDAO.findById(id);
        System.out.println("Instructor Info before Update: "+instructor);
        instructor.setInstructorLastName("RAGHU");
        appDAO.updateInstructor(instructor);/*
        Instructor instructor1 = appDAO.findById(id);*/
        System.out.println("Instructor Info after Update: "+instructor);
    }

    private void findCoursesForInstructorJoinFetch(AppDAO appDAO) {
        int id =1;
        System.out.println("Finding instructor By id: "+id);
        //finding the instructor
        Instructor instructor1 = appDAO.findInstructorByIdJoinFetch(id);
        System.out.println("The Instructor is: "+instructor1);
        //finding the courses for instructor
        System.out.println("The Courses are: ");
        for(Course course : instructor1.getCourses() )
        {
            System.out.println(course);
        }
    }

    private void findCoursesForInstructor(AppDAO appDAO) {

        int id =1;
        System.out.println("Finding instructor By id: "+id);
        Instructor instructor = appDAO.findById(id);
        System.out.println("The Instructor is: "+instructor);
        //finding the courses for instructor
        List<Course> courses = appDAO.findCoursesByInstructorId(id);
        System.out.println("The Courses are: ");
        for(Course course : courses)
        {
            System.out.println(course);
        }
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int id=1;
        Instructor instructor = appDAO.findById(id);
        System.out.println("Instructor Detail: "+instructor);
        System.out.println("The Associated Courses:"+instructor.getCourses());

    }

    private void createInstructorWithCourse(AppDAO appDAO) {

        Instructor instructor = new Instructor("Vijay","Raghavendra","vijay@email.com");

        InstructorDetail instructorDetail = new InstructorDetail("http://www.aim2code.com/youtube.com","watching dichakdichak");

        instructor.setInstructorDetail(instructorDetail);

        Course course1 = new Course("Spring Boot JPA");
        Course course2 = new Course("Spring Boot REST");
        Course course3 = new Course("Spring Boot MVC");
        Course course4 = new Course("Spring Boot HIBERNATE");

        instructor.add(course1);
        instructor.add(course2);
        instructor.add(course3);
        instructor.add(course4);

        appDAO.save(instructor);

    }

    private void DeleteInstructorDetailsById(AppDAO appDAO) {
        int theId = 6;
        InstructorDetail instructorDetails = appDAO.findInstructorDetailById(theId);
        System.out.println("Found the instructor Details with Details Below "+ instructorDetails.toString());
        System.out.println("And its associated Instructor"+ instructorDetails.getInstructor());
        /*System.out.println("ID: " + instructor.getId());
        System.out.println("First Name: " + instructor.getInstructorFirstName());
        System.out.println("Last Name: " + instructor.getInstructorLastName());
        System.out.println("Email: " + instructor.getInstructorEmail());
        System.out.println("Instructor Details"+ instructor.getInstructorDetail());*/
        if(instructorDetails != null)
        {
            appDAO.DeleteInstructorDetailById(theId);
        }
        System.out.println("Deleted the instructor Successfully");
    }

    private void findInstructorDetailById(AppDAO appDAO) {
        int id=2;
        System.out.println("finding InstructorDetail By Id: "+ id);
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
        System.out.println("InstructorDetail: "+ instructorDetail.toString());
        System.out.println("Associated instructor: "+ instructorDetail.getInstructor());
    }

    private void DeleteInstructorById(AppDAO appDAO) {
        int theId = 3;
        Instructor instructor = appDAO.findById(theId);
        System.out.println("Found the instructor with Details Below");
        System.out.println("ID: " + instructor.getId());
        System.out.println("First Name: " + instructor.getInstructorFirstName());
        System.out.println("Last Name: " + instructor.getInstructorLastName());
        System.out.println("Email: " + instructor.getInstructorEmail());
        System.out.println("Instructor Details"+ instructor.getInstructorDetail());
        if(instructor != null)
        {
            appDAO.deleteInstructorById(theId);
        }
        System.out.println("Deleted the instructor Successfully");
    }

    private void findInstructorById(AppDAO appDAO) {
        int theId = 2;
        System.out.println("findingInstructor By Id: "  + theId);
        Instructor instructor = appDAO.findById(theId);
        System.out.println(instructor.toString());
    }

    private void CreateOrSaveInstructor(AppDAO appDAO) {
        Instructor instructor = new Instructor("dummy","person","dummy@email.com");

        InstructorDetail instructorDetail = new InstructorDetail("http://www.aim2code.com/oasdasdas","desire and aim 2 Code");

        instructor.setInstructorDetail(instructorDetail);

        appDAO.save(instructor);
    }

}
