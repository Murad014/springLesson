package com.thymleaf.thymleaf.service;

import com.thymleaf.thymleaf.entity.Student;
import com.thymleaf.thymleaf.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> fetchAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student fetchBytId(int id) {
        Optional<Student> op = studentRepository.findById(id);
        return op.orElse(null);
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
