package com.studentMVC.studentMVC.repository;

import com.studentMVC.studentMVC.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
