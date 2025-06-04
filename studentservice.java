package com.example.sms.service;
import com.example.sms.model.Student;
import com.example.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class StudentService {
 @Autowired
 private StudentRepository repository;
 public Page<Student> getAllStudents(int page, int size) {
 return repository.findAll(PageRequest.of(page, size));
 }
 public Student saveStudent(Student student) {
 return repository.save(student);
 }
 public Optional<Student> getStudentById(Long id) {
 return repository.findById(id);
 }
 public void deleteStudent(Long id) {
 repository.deleteById(id);
 }
 public Page<Student> searchByName(String name, int page, int size) {
 return repository.findByNameContainingIgnoreCase(name, PageRequest.of(page, size));
 }
 public Page<Student> filterByClass(String studentClass, int page, int size) {
 return repository.findByStudentClassIgnoreCase(studentClass, PageRequest.of(page, size));
 }
}
