import com.example.attendance.model.Attendance; import
com.example.attendance.model.Employee; import
com.example.attendance.repository.AttendanceRepository; import
com.example.attendance.repository.EmployeeRepository; import
org.springframework.beans.factory.annotation.Autowired; import
org.springframework.stereotype.Service;
import java.time.LocalDate; import java.util.List;
@Service public class AttendanceService { @Autowired private AttendanceRepository
attendanceRepo; @Autowired private EmployeeRepository employeeRepo;
public Attendance markAttendance(Long empId, String status) {
 Employee emp = employeeRepo.findById(empId).orElseThrow();
 Attendance att = new Attendance(null, emp, LocalDate.now(), status);
 return attendanceRepo.save(att);
}
public List<Attendance> getAttendanceByEmployee(Long empId) {
 Employee emp = employeeRepo.findById(empId).orElseThrow();
 return attendanceRepo.findByEmployee(emp);
}
public List<Attendance> getAttendanceByDepartment(String department) {
 return attendanceRepo.findByEmployeeDepartment(department);
}
}
