import org.springframework.boot.SpringApplication; import
org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication public class EmployeeAttendanceApplication { public static void main(String[]
args) { SpringApplication.run(EmployeeAttendanceApplication.class, args); } }
// File: model/Employee.java package com.example.attendance.model;
import jakarta.persistence.; import lombok.;
@Entity @Data @NoArgsConstructor @AllArgsConstructor public class Employee { @Id
@GeneratedValue(strategy = GenerationType.IDENTITY) private Long employeeId;
private String name;
private String department;
private String designation;
}
