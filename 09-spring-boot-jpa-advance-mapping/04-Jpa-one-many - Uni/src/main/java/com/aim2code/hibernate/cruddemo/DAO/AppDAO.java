package com.aim2code.hibernate.cruddemo.DAO;

import com.aim2code.hibernate.cruddemo.entity.Course;
import com.aim2code.hibernate.cruddemo.entity.Instructor;
import com.aim2code.hibernate.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(Integer id);

    void deleteInstructorById(Integer id);

    InstructorDetail findInstructorDetailById(Integer id);

    void DeleteInstructorDetailById(Integer id);

    List<Course> findCoursesByInstructorId(Integer id);

    Instructor findInstructorByIdJoinFetch(Integer id);

    void updateInstructor(Instructor instructor);

    void SaveCouse(Course course);

    Course findCourseAndReviewByCourseId(Integer id);
}
