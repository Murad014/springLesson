package com.thymleaf.thymleaf.controller;

import com.thymleaf.thymleaf.entity.Student;
import com.thymleaf.thymleaf.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    @GetMapping("/list")
    public String fetchAll(Model model){
        List<Student> students = studentService.fetchAll();
        model.addAttribute("students", students);

        return "student/students";
    }

    @GetMapping("/addForm")
    public String saveForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);

        return "student/add_form";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("student") Student student){
        studentService.createOrUpdate(student);

        return "redirect:/students/list";
    }

    @GetMapping("/updateForm")
    public String updateForm(@RequestParam("id") int id, Model model){
        Student studentFromDB = studentService.fetchBytId(id);
        model.addAttribute("student", studentFromDB);
        return "student/add_form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        Student studentFromDB = studentService.fetchBytId(id);
        if(studentFromDB != null)
            studentService.delete(studentFromDB);

        return "redirect:/students/list";

    }


}
