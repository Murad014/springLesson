package com.studentMVC.studentMVC.service;

import com.studentMVC.studentMVC.entity.Student;
import com.studentMVC.studentMVC.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> fetchAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student fetchById(int id) {
        Optional<Student> studentFromDB = studentRepository.findById(id);
        return studentFromDB.orElse(null);
    }

    @Override
    public Student createOrUpdate(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }
}
