package net.microservice.employeeservice.service;

import net.microservice.employeeservice.dto.APIResponseDto;
import net.microservice.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long id);
}
