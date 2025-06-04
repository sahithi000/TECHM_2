package com.example.sms.repository;
import com.example.sms.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<Student, Long> {
 Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable);
 Page<Student> findByStudentClassIgnoreCase(String studentClass, Pageable pageable);
}
