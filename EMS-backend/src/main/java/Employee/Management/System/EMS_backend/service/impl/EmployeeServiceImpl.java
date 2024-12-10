package Employee.Management.System.EMS_backend.service;

import Employee.Management.System.EMS_backend.dto.EmployeeDto;
import Employee.Management.System.EMS_backend.entity.Employee;
import Employee.Management.System.EMS_backend.mapper.EmployeeMapper;
import Employee.Management.System.EMS_backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    // Manually created constructor for dependency injection
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // Map the EmployeeDto to Employee entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        // Save the employee to the database
        Employee savedEmployee = employeeRepository.save(employee);

        // Convert saved Employee back to EmployeeDto and return it
        return EmployeeMapper.maptoEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        

        return null;
    }
}
