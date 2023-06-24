package com.studentMVC.studentMVC.controller;

import com.studentMVC.studentMVC.entity.Student;
import com.studentMVC.studentMVC.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    @GetMapping("/list")
    public String getAllStudent(Model model){
        List<Student> students = studentService.fetchAll();
        model.addAttribute("students", students);

        return "student/student_list";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);

        return "student/add_student";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("student") Student student){
        Student newStudent = studentService.createOrUpdate(student);
        return "redirect:/student/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        System.out.println("Id: " + id);
        Student studentFromDB = studentService.fetchById(id);
        System.out.println(studentFromDB);
        model.addAttribute("student", studentFromDB);

        return "student/update_form";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute("student") Student student){
        Student updatedStudent = studentService.createOrUpdate(student);
        return "redirect:/student/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        Student studentFromDB = studentService.fetchById(id);
        studentService.delete(studentFromDB);
        return "redirect:/student/list";
    }



}
