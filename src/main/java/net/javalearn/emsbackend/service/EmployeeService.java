package net.javalearn.emsbackend.service;

import net.javalearn.emsbackend.dto.EmployeeDto;

import java.util.*;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployee);
    void deleteEmployee(Long employeeId);
}
