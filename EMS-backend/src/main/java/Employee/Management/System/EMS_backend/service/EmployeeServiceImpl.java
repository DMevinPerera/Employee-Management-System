package Employee.Management.System.EMS_backend.service;

import Employee.Management.System.EMS_backend.dto.EmployeeDto;
import Employee.Management.System.EMS_backend.entity.Department;
import Employee.Management.System.EMS_backend.entity.Employee;
import Employee.Management.System.EMS_backend.exception.ResourceNotFoundException;
import Employee.Management.System.EMS_backend.mapper.EmployeeMapper;
import Employee.Management.System.EMS_backend.repository.DepartmentRepository;
import Employee.Management.System.EMS_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    // Constructor for dependency injection
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // Map EmployeeDto to Employee entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        // Find the department by ID
        Department department = departmentRepository.findById(employeeDto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Department does not exist with id: " + employeeDto.getDepartmentId()));
        employee.setDepartment(department);

        // Save the employee to the database
        Employee savedEmployee = employeeRepository.save(employee);

        // Convert saved Employee back to EmployeeDto and return it
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        // Find the employee by ID
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Employee does not exist with id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        // Retrieve all employees and map them to DTOs
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        // Find the employee by ID
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Employee does not exist with id: " + employeeId));

        // Update employee details
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());

        // Find the department by ID and set it
        Department department = departmentRepository.findById(updateEmployee.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Department does not exist with id: " + updateEmployee.getDepartmentId()));
        employee.setDepartment(department);

        // Save the updated employee
        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        // Find the employee by ID
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Employee does not exist with id: " + employeeId));

        // Delete the employee
        employeeRepository.deleteById(employeeId);
    }
}