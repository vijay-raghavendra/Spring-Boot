package com.aim2code.hibernate.cruddemo.DAO;

import com.aim2code.hibernate.cruddemo.entity.Course;
import com.aim2code.hibernate.cruddemo.entity.Instructor;
import com.aim2code.hibernate.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(Integer id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        return instructor;
    }

    @Override
    @Transactional
    public void deleteInstructorById(Integer id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(Integer id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void DeleteInstructorDetailById(Integer id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(Integer id) {

        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :instructorId", Course.class);
        query.setParameter("instructorId", id);
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(Integer id) {
        TypedQuery<Instructor> instructorTypedQuery = entityManager.createQuery(
                "select i from Instructor i"+
                        " JOIN FETCH i.courses"+
                        " JOIN FETCH i.instructorDetail"+
                        " where i.id = :instructorId", Instructor.class);
        instructorTypedQuery.setParameter("instructorId", id);
        return instructorTypedQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }
}
