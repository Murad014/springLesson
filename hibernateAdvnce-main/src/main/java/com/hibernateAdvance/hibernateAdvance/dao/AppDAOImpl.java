package com.hibernateAdvance.hibernateAdvance.dao;


import com.hibernateAdvance.hibernateAdvance.entity.Course;
import com.hibernateAdvance.hibernateAdvance.entity.Instructor;
import com.hibernateAdvance.hibernateAdvance.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class AppDAOImpl implements AppDAO{
    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor );
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Instructor instructorFromDB = entityManager.find(Instructor.class, 1);
        entityManager.remove(instructorFromDB);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        entityManager.remove(instructorDetail);
    }

    @Override
    @Transactional
    public void addCourse(Course course) {
        Course newCourse = entityManager.merge(course);

    }

    @Override
    public Course findCoursById(int id) {
        return entityManager.find(Course.class, id);
    }


}
