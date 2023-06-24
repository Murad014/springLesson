package com.studentMVC.studentMVC.service;

import com.studentMVC.studentMVC.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> fetchAll();
    Student fetchById(int id);
    Student createOrUpdate(Student student);
    void delete(Student student);


}
