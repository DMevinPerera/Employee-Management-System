package Employee.Management.System.EMS_backend.repository;

import Employee.Management.System.EMS_backend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}

