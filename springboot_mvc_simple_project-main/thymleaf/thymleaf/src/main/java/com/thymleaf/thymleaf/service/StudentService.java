package com.thymleaf.thymleaf.service;

import com.thymleaf.thymleaf.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> fetchAll();

    Student fetchBytId(int id);

    Student createOrUpdate(Student student);

    void delete(Student student);

}
