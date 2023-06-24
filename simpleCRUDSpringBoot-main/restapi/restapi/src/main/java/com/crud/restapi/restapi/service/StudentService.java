package com.crud.restapi.restapi.service;

import com.crud.restapi.restapi.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> fetchAll();
    Student fetchById(int id);
    Student saveOrUpdate(Student student);
    void delete(Student student);
}
