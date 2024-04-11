package net.javalearn.emsbackend.service.impl;

import lombok.AllArgsConstructor;
import net.javalearn.emsbackend.dto.EmployeeDto;
import net.javalearn.emsbackend.entity.Employee;
import net.javalearn.emsbackend.exception.ResourceNotFoundException;
import net.javalearn.emsbackend.mapper.EmployeeMapper;
import net.javalearn.emsbackend.repository.EmployeeRepository;
import net.javalearn.emsbackend.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
       Employee employee= EmployeeMapper.maptoEmployee(employeeDto);
       Employee savedEmployee=employeeRepository.save(employee);
       return EmployeeMapper.maptoEmployeeDto(savedEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee= employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee Doesn't Exist with employee id"+employeeId));
       return EmployeeMapper.maptoEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees= employeeRepository.findAll();
        return employees.stream().map((employee)->EmployeeMapper.maptoEmployeeDto(employee))
                .collect(Collectors.toList());

    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Enployee doesnt't exist")
        );
        employee.setFirstname(updatedEmployee.getFirstName());
        employee.setLastname(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeobj=employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(updatedEmployeeobj);

    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Enployee doesnt't exist")
        );
        employeeRepository.deleteById(employeeId);

    }


}
