package com.thymeleaf.thymeleaf.repository;

import com.thymeleaf.thymeleaf.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {



}
