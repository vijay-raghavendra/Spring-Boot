package com.aim2code.hibernate.cruddemo.DAO;

import com.aim2code.hibernate.cruddemo.entity.Instructor;
import com.aim2code.hibernate.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(Integer id);

    void deleteInstructorById(Integer id);

    InstructorDetail findInstructorDetailById(Integer id);

    void DeleteInstructorDetailById(Integer id);
}
