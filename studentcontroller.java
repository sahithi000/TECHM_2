package com.example.sms.controller;
import com.example.sms.model.Student;
import com.example.sms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/students")
public class StudentController {
 @Autowired
 private StudentService service;
 @GetMapping
 public String listStudents(Model model,
 @RequestParam(defaultValue = "0") int page,
 @RequestParam(defaultValue = "5") int size) {
 model.addAttribute("studentPage", service.getAllStudents(page, size));
 return "students";
 }
 @GetMapping("/add")
 public String showAddForm(Model model) {
 model.addAttribute("student", new Student());
 return "student-form";
 }
 @PostMapping("/save")
 public String saveStudent(@Valid @ModelAttribute Student student,
 BindingResult result, Model model) {
 if (result.hasErrors()) {
 return "student-form";
 }
 service.saveStudent(student);
 return "redirect:/students";
 }
 @GetMapping("/edit/{id}")
 public String showEditForm(@PathVariable Long id, Model model) {
 Student student = service.getStudentById(id).orElseThrow();
 model.addAttribute("student", student);
 return "student-form";
 }
 @GetMapping("/delete/{id}")
 public String deleteStudent(@PathVariable Long id) {
 service.deleteStudent(id);
 return "redirect:/students";
 }
 @GetMapping("/search")
 public String searchStudents(@RequestParam String keyword,
 @RequestParam(defaultValue = "0") int page,
 @RequestParam(defaultValue = "5") int size,
Model model) {
 Page<Student> result = service.searchByName(keyword, page, size);
 model.addAttribute("studentPage", result);
 return "students";
 }
 @GetMapping("/filter")
 public String filterByClass(@RequestParam String studentClass,
 @RequestParam(defaultValue = "0") int page,
 @RequestParam(defaultValue = "5") int size,
 Model model) {
 Page<Student> result = service.filterByClass(studentClass, page, size);
 model.addAttribute("studentPage", result);
 return "students";
 }
}
