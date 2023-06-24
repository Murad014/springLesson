package com.crud.restapi.restapi.service;
import com.crud.restapi.restapi.doa.StudentDAO;
import com.crud.restapi.restapi.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentDAO studentDAO;
    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }


    @Override
    public List<Student> fetchAll() {
        return studentDAO.fetchAll();
    }

    @Override
    public Student fetchById(int id) {
        return studentDAO.fetchById(id);
    }

    @Override
    @Transactional
    public Student saveOrUpdate(Student student) {
        return studentDAO.saveOrUpdate(student);
    }

    @Override
    @Transactional
    public void delete(Student student) {
        studentDAO.delete(student);
    }
}
