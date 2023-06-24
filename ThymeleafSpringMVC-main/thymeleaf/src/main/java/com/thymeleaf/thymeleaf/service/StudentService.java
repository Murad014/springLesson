package com.thymeleaf.thymeleaf.service;

import com.thymeleaf.thymeleaf.entity.Student;
import java.util.List;

public interface StudentService {

    List<Student> fetchAll();
    Student fetchById(int id);
    Student createOrUpdate(Student student);
    void delete(Student student);




}
