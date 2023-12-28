package net.microservice.departmentservice.controller;

import lombok.AllArgsConstructor;
import net.microservice.departmentservice.dto.DepartmentDto;
import net.microservice.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {


    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment =  departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code")  String departmentCode){
        DepartmentDto department = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(department,HttpStatus.OK);
    }
}
