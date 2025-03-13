package it.nxtvision.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.nxtvision.model.Student;
import it.nxtvision.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Display all students
    @GetMapping
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student-list";
    }

    // Display student form (for creating and editing)
    @GetMapping("/new")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    // Create student
    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student) {
        studentService.createStudent(student);
        return "redirect:/students";
    }

    // Show student details
    @GetMapping("/{id}")
    public String showStudentDetails(@PathVariable("id") Long id, Model model) {
        Optional<Student> student = studentService.getStudentById(id);
        student.ifPresent(value -> model.addAttribute("student", value));
        return "student-detail";
    }

    // Edit student
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Student> student = studentService.getStudentById(id);
        student.ifPresent(value -> model.addAttribute("student", value));
        return "student-form";
    }

    // Update student
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute Student student) {
        studentService.updateStudent(id, student);
        return "redirect:/students";
    }

    // Delete student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}

