package com.springdatarest.springdatarest.dao;

import com.springdatarest.springdatarest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
