package com.crud.restapi.restapi.doa;

import com.crud.restapi.restapi.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentImpl implements  StudentDAO{

    private final EntityManager entityManager;

    @Autowired
    public StudentImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> fetchAll() {
        TypedQuery<Student> studentsDB = entityManager.createQuery("from Student", Student.class);
        return studentsDB.getResultList();
    }

    @Override
    public Student fetchById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student saveOrUpdate(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public void delete(Student student) {
        entityManager.remove(student);
    }



}
