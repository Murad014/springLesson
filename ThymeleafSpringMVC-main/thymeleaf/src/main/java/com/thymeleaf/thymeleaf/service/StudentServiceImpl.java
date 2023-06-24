package com.thymeleaf.thymeleaf.service;

import com.thymeleaf.thymeleaf.entity.Student;
import com.thymeleaf.thymeleaf.repository.StudentRepository;
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
        Optional<Student> studentOp = studentRepository.findById(id);
        return studentOp.orElse(null);
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
