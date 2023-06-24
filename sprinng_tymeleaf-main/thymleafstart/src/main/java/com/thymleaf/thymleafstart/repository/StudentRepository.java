package com.thymleaf.thymleafstart.repository;

import com.thymleaf.thymleafstart.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByOrderByFirstNameAsc();
}
