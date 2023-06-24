package com.thymeleaf.thymeleaf.controller;

import com.thymeleaf.thymeleaf.entity.Student;
import com.thymeleaf.thymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String listForm(Model model){
        List<Student> allStudent = studentService.fetchAll();
        model.addAttribute("students", allStudent);

        return "student/student";
    }


    @GetMapping("/addForm")
    public String addForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);

        return "student/add_student";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student){
        studentService.createOrUpdate(student);
        return "redirect:/student/list";
    }

    @GetMapping("/updateForm")
    public String updateStudentForm(@RequestParam("id") int id, Model model){
        Student studentFromDb = studentService.fetchById(id);
        model.addAttribute("student", studentFromDb);
        return "student/update_student";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute("student") Student student){
        studentService.createOrUpdate(student);
        return "redirect:/student/list";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("id") int id){
        Student studentFromDB = studentService.fetchById(id);
        if(studentFromDB != null)
            studentService.delete(studentFromDB);

        return "redirect:/student/list";
    }






}
