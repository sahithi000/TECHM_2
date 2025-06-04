package com.example.sms.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long studentId;
 @NotBlank(message = "Name is mandatory")
 private String name;
 @Min(value = 5, message = "Minimum age is 5")
 @Max(value = 100, message = "Maximum age is 100")
 private int age;
 @NotBlank(message = "Class is mandatory")
 private String studentClass;
 @Email(message = "Invalid email format")
 @NotBlank(message = "Email is mandatory")
 private String email;
 @NotBlank(message = "Address is mandatory")
 private String address;
}
