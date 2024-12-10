package Employee.Management.System.EMS_backend.repository;

import Employee.Management.System.EMS_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
