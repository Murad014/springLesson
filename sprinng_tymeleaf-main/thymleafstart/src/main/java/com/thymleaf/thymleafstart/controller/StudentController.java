package com.thymleaf.thymleafstart.controller;

import com.thymleaf.thymleafstart.entity.Student;
import com.thymleaf.thymleafstart.service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;

    }

    @GetMapping("/list")
    public String fetchAll(Model model){
        List<Student> students = studentService.fetchAll();
        model.addAttribute("students", students);
        return "student";
    }

    @GetMapping("/showFormAdd")
    public String showFormAdd(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "add_student";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student){
        studentService.createOrUpdate(student);
        return "redirect:/students/list"; // We use redirect to prevent duplicate submission
    }

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("id") int id, Model model){
        Student student = studentService.fetchById(id);
        model.addAttribute("student", student);

        return "add_student";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, HttpSession session){
        Student student = studentService.fetchById(id);

        if(student == null) {
            session.setAttribute("isError", true);
            session.setAttribute("errorMessage", "Student does not exist in DB!");
        }else
            studentService.delete(student);


        return "redirect:/students/list";
    }




}
