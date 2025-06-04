import jakarta.persistence.; import lombok.; import java.time.LocalDate;
@Entity @Data @NoArgsConstructor @AllArgsConstructor public class Attendance { @Id
@GeneratedValue(strategy = GenerationType.IDENTITY) private Long attendanceId;
@ManyToOne
@JoinColumn(name = "employee_id")
private Employee employee;
private LocalDate date;
private String status; // Present or Absent
}
