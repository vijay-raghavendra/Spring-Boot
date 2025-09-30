package com.aim2code.crudDemo.DAO;

import java.util.List;

import com.aim2code.crudDemo.entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	
	Student findById(int id);
	
	List<Student> findAll();
	
	List<Student> findByLastname(String lastName);
	
	void update(Student student);
	
	void delete(int id);
	
	int DeleteAll();

}
