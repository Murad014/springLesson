package com.daocrud.daocrud.rest;


import com.daocrud.daocrud.entity.Employee;
import com.daocrud.daocrud.exception.StudentNotFoundException;
import com.daocrud.daocrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @GetMapping("/employee/list")
    public List<Employee> fetchAll(){
        return employeeService.fetchAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee fetchById(@PathVariable("employeeId") int id){
        Employee employee = employeeService.findById(id);
        if(employee == null)
            throw new StudentNotFoundException("Student not found: " + id);
        return employeeService.findById(id);
    }


    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        return employeeService.save(theEmployee);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        return employeeService.save(theEmployee);

    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployeeById(@PathVariable("employeeId") int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null)
            throw new StudentNotFoundException(String.format("%s called id does not exist in DB ", employeeId));

        employeeService.deleteById(employeeId);
        return "Deleted. Id: " + employeeId;

    }










}
