package net.microservice.employeeservice.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import net.microservice.employeeservice.dto.APIResponseDto;
import net.microservice.employeeservice.dto.DepartmentDto;
import net.microservice.employeeservice.dto.EmployeeDto;
import net.microservice.employeeservice.entity.Employee;
import net.microservice.employeeservice.repository.EmployeeRepository;
import net.microservice.employeeservice.service.APIClient;
import net.microservice.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl  implements EmployeeService {

    private  EmployeeRepository employeeRepository;

//    private RestTemplate restTemplate;

//    private WebClient webClient;

    private APIClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

      Employee savedEmployee  =  employeeRepository.save(employee);
      EmployeeDto savedEmployeeDto  = new EmployeeDto(
              savedEmployee.getId(),
              savedEmployee.getFirstName(),
              savedEmployee.getLastName(),
              savedEmployee.getEmail(),
              savedEmployee.getDepartmentCode()
      );
        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);


//        RestTemplate

//         ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(),
//                DepartmentDto.class);
//
//         DepartmentDto departmentDto = responseEntity.getBody();


//        WebClient

//        DepartmentDto departmentDto =   webClient.get()
//                .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

//       DepartmentDto departmentDto =  apiClient.getDepartment(employee.getDepartmentCode());
//
//        EmployeeDto employeeDto = new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail(),
//                employee.getDepartmentCode()
//        );
//
//        APIResponseDto apiResponse = new APIResponseDto();
//        apiResponse.setEmployee(employeeDto);
//        apiResponse.setDepartment(departmentDto);
//        return apiResponse;


        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();

            // RestTemplate
            // ... (your RestTemplate code)

            // WebClient
            // ... (your WebClient code)

            DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

            EmployeeDto employeeDto = new EmployeeDto(
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getEmail(),
                    employee.getDepartmentCode()
            );

            APIResponseDto apiResponse = new APIResponseDto();
            apiResponse.setEmployee(employeeDto);
            apiResponse.setDepartment(departmentDto);
            return apiResponse;
        } else {
            // Handle the case where the employee with the given id is not found
            // You might want to throw an exception, return an error response, or handle it as appropriate for your application
            // For example:
            throw new EntityNotFoundException("Employee not found with ID: " + id);
        }
    }
}
