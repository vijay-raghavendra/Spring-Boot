package com.aim2code.hibernate.cruddemo;

import com.aim2code.hibernate.cruddemo.DAO.AppDAO;
import com.aim2code.hibernate.cruddemo.entity.Instructor;
import com.aim2code.hibernate.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.*;

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
            DeleteInstructorDetailsById(appDAO);
        };
    }

    private void DeleteInstructorDetailsById(AppDAO appDAO) {
        int theId = 4;
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
