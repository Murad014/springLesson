package com.daocrud.daocrud.dao;

import com.daocrud.daocrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {




}
