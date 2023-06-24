package com.thymleaf.thymleafstart.service;

import com.thymleaf.thymleafstart.entity.Student;
import com.thymleaf.thymleafstart.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final  StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> fetchAll() {
        return studentRepository.findAllByOrderByFirstNameAsc();
    }

    @Override
    public Student fetchById(int id) {
        Optional<Student> opt = studentRepository.findById(id);
        return opt.orElse(null);
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
