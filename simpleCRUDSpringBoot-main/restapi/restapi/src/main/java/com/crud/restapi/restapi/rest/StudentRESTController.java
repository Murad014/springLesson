package com.crud.restapi.restapi.rest;

import com.crud.restapi.restapi.doa.StudentDAO;
import com.crud.restapi.restapi.doa.StudentImpl;
import com.crud.restapi.restapi.entity.Student;
import com.crud.restapi.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRESTController {
    private final StudentService studentService;

    @Autowired
    public StudentRESTController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> fetchAll(){
        return studentService.fetchAll();
    }

    @GetMapping("/students/{studentId}")
    public Student fetchById(@PathVariable("studentId") int studentId){
        return studentService.fetchById(studentId);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student newStudent){
        newStudent.setId(0);
        return studentService.saveOrUpdate(newStudent);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student updateStudent){
        return studentService.saveOrUpdate(updateStudent);
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable("studentId") int studentId){
        Student studentFromDB = studentService.fetchById(studentId);
        if(studentFromDB == null)
            return String.format("With %s id does not exist in DB", studentId);

        studentService.delete(studentFromDB);
        return String.format("%s id deleted.", studentId);
    }





}
