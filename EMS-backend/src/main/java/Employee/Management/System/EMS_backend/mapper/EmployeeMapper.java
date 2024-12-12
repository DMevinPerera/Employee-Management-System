package Employee.Management.System.EMS_backend.mapper;

import Employee.Management.System.EMS_backend.dto.EmployeeDto;
import Employee.Management.System.EMS_backend.entity.Employee;

public class EmployeeMapper {

    // Method to map Employee entity to EmployeeDto
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment() != null ? employee.getDepartment().getId() : null // Null safety
        );
    }

    // Method to map EmployeeDto to Employee entity
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail()); // Fixed incorrect reference
        return employee;
    }
}
