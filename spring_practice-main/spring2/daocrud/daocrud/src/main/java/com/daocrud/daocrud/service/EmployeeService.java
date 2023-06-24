package com.daocrud.daocrud.service;

import com.daocrud.daocrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> fetchAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
