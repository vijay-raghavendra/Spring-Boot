package com.aim2code.crudDemo.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aim2code.crudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class StudentDAOImpl implements StudentDAO{

	//define fields for entity manager
	private EntityManager entityManager;
	
	//inject entity manager using constructor injection
	public StudentDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	//implement save Method
	@Override
	@org.springframework.transaction.annotation.Transactional
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.persist(theStudent);
		
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<Student> students = entityManager.createQuery("from Student order by lastname",Student.class);
		
		
		return students.getResultList();
	}

	@Override
	public List<Student> findByLastname(String lastName) {
		// TODO Auto-generated method stub
		
		TypedQuery<Student> students = entityManager.createQuery("From Student where lastname=:theData",Student.class);
		
		students.setParameter("theData", lastName);
		
		return students.getResultList();
	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public void update(Student student) {
		// TODO Auto-generated method stub
		
		entityManager.merge(student);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		Student stud = entityManager.find(Student.class, id);
		
		entityManager.remove(stud);
		
	}

	@Override
	@Transactional
	public int DeleteAll() {
		// TODO Auto-generated method stub
		int number = entityManager.createQuery("Delete from Student").executeUpdate();
		return number;
	}

	

}
