package Employee.Management.System.EMS_backend.service.impl;

import Employee.Management.System.EMS_backend.dto.EmployeeDto;
import Employee.Management.System.EMS_backend.entity.Employee;
import Employee.Management.System.EMS_backend.mapper.EmployeeMapper;
import Employee.Management.System.EMS_backend.repository.EmployeeRepository;
import Employee.Management.System.EMS_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.maptoEmployeeDto(savedEmployee);
    }
}
