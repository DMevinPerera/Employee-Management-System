package Employee.Management.System.EMS_backend.controller;

import Employee.Management.System.EMS_backend.dto.DepartmentDto;
import Employee.Management.System.EMS_backend.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    // Constructor for dependency injection
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // Build Create or Add department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }
}

