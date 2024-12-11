package Employee.Management.System.EMS_backend.mapper;

import Employee.Management.System.EMS_backend.dto.DepartmentDto;
import Employee.Management.System.EMS_backend.entity.Department;

public class DepartmentMapper {



    // convert department jpa entity into department dto
    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }


    //convert department dto into department jpa entity
    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()

        );
    }



}
