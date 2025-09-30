package com.aim2code.crudDemo;
import java.io.PrintStream;
import java.util.List;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.aim2code.crudDemo.DAO.StudentDAO;
import com.aim2code.crudDemo.entity.Student;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner ->{
			//createStudent(studentDAO);
			
			createMultipleStudents(studentDAO);
			
			//getAllStudentsData(studentDAO);
			
			//readStudent(studentDAO);
			
			//getStduentsByLastname(studentDAO);
			
			//creatingDuplicate(studentDAO);
			
			//updateStudent(studentDAO);
			
			//deletingStudent(studentDAO);
			
			//deleteAllStudents(studentDAO);
		};
	}
	private void deleteAllStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		System.out.println("Deleting all the rows of Student Table");
		System.out.println("Number of students Deleted:\t"+ studentDAO.DeleteAll());
		
	}
	private void deletingStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		System.out.println("Lets Delete the English Man from our Students Table");
		studentDAO.delete(1);
		System.out.println("Delete the English man");
		
	}
	
	private void updateStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		Student stud = studentDAO.findById(studentDAO.findAll().size());
		System.out.println("Getting the Id of the student to be updated:"+stud);
		Student updatedStudent = stud;
		updatedStudent.setFirstname("Sushanth Kumar");
		updatedStudent.setLastname("HR");
		updatedStudent.setEmail("sushu@icici.com");
		System.out.println("Updating the student first Name to: "+updatedStudent.getFirstname()+"\tlastName to: "+updatedStudent.getLastname()+"\temail ID to: "+updatedStudent.getEmail());
		studentDAO.update(updatedStudent);
		
	}
	private void creatingDuplicate(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		Student duplicateStudent =  new Student("Paul", "Doe", "paul@luv2code.com");
		studentDAO.save(duplicateStudent);
		
	}
	private void getStduentsByLastname(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		List<Student> students = studentDAO.findByLastname("Kumar");
		System.out.println("Now we are retreving all the data from the Students Table whose last name is Kumar");
		System.out.println("----------------------------------------------------------");
		for(Student abc:students)
		{
			System.out.println("Id:-"+abc.getId()+"\tName:-"+abc.getFirstname()+" "+abc.getLastname()+"\tEmail Id:-"+abc.getEmail()+"\n");
		}
		System.out.println("----------------------------------------------------------");
	}
	private void getAllStudentsData(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		List<Student> studentsList = studentDAO.findAll();
		System.out.println("Now we are retreving all the data from the Students Table");
		System.out.println("----------------------------------------------------------");
		for(Student abc:studentsList)
		{
			System.out.println("Id:-"+abc.getId()+"\tName:-"+abc.getFirstname()+" "+abc.getLastname()+"\tEmail Id:-"+abc.getEmail()+"\n");
		}
		System.out.println("----------------------------------------------------------");
	}
	private void readStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		/*
		 * // create the student object
		 * System.out.println("Creating new student object ..."); Student tempStudent =
		 * new Student("Paul", "Doe", "paul@luv2code.com");
		 * 
		 * // save the student object System.out.println("Saving the student ...");
		 * studentDAO.save(tempStudent);
		 * 
		 * // display id of the saved student
		 * System.out.println("Saved student. Generated id: " + tempStudent.getId());
		 * 
		 * //reteriving the student based on the ID:Primary key
		 * System.out.println("reteriving the student with the given Id"); Student
		 * myStudent = studentDAO.findById(tempStudent.getId());
		 */
		Student wantedStudent = studentDAO.findById(studentDAO.findAll().size());
		 
		//display student
		System.out.println("Finding the last Student Details in the Student Table");
		System.out.println("Reterived the student :"+wantedStudent);
		
		
	}
	private void createMultipleStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		//create multiple students 
		System.out.println("Creating 3 new student object's ...");
		Student student1 = new Student("vjiay","Raghu","vj@gmail.com");
		Student student2 = new Student("Naveen","Kumar","Nv@gmail.com");
		Student student3 = new Student("Mallai","setty","Ms@gmail.com");
		
		//save the created multiple students
		System.out.println("Saving the 3 new students ...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		
	}
	private void createStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		// create the student object
				System.out.println("Creating 1st student object ...");
				Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

				// save the student object
				System.out.println("Saving the student ...");
				studentDAO.save(tempStudent);

				// display id of the saved student
				System.out.println("Saved student. Generated id: " + tempStudent.getId());
		
	}

}
