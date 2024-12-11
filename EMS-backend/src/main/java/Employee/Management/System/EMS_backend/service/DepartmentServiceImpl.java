package Employee.Management.System.EMS_backend.service;

import Employee.Management.System.EMS_backend.dto.DepartmentDto;
import Employee.Management.System.EMS_backend.entity.Department;
import Employee.Management.System.EMS_backend.mapper.DepartmentMapper;
import Employee.Management.System.EMS_backend.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    // Constructor for dependency injection
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }
}

