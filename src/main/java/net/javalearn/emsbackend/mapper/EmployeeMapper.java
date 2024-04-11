package net.javalearn.emsbackend.mapper;

import net.javalearn.emsbackend.dto.EmployeeDto;
import net.javalearn.emsbackend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto maptoEmployeeDto(Employee employee)
    {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail()
        );
    }
    public  static Employee maptoEmployee(EmployeeDto employeeDto)
    {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }

}
