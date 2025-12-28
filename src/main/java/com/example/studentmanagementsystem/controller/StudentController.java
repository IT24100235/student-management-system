package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentRepository repository;

    // This connects the controller to the repository (Dependency Injection)
    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    // This tells the browser to show the "index" page when you visit http://localhost:8080/
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listStudents", repository.findAll());
        return "index";
    }

    // This handles the "Add Student" button click [cite: 15]
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        repository.save(student);
        return "redirect:/";
    }

    // This handles the "Delete" link [cite: 15]
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}