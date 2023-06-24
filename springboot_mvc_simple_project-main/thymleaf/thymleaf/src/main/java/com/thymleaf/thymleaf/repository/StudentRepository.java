package com.thymleaf.thymleaf.repository;

import com.thymleaf.thymleaf.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student, Integer> {

}
